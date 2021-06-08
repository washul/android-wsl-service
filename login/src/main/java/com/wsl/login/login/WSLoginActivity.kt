package com.wsl.login.login

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.facebook.CallbackManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.wsl.login.R
import com.wsl.login.database.entities.EUser
import com.wsl.login.helpers.*
import com.wsl.login.login.view_model.WSLoginViewModel
import com.wsl.login.retrofit.LoginResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

const val TAG_LOGIN = "WSLoginActivity "
@AndroidEntryPoint
class WSLoginActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: WSLoginViewModel

    private lateinit var progressBarCustom: WSProgressBarCustom

    @Inject
    lateinit var callbackManager: CallbackManager

    @Inject
    lateinit var gso: GoogleSignInOptions

    @Inject
    lateinit var mGoogleSignInClient: GoogleSignInClient

    @Inject
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.activityAction = intent.getIntExtra( WSL_ACTION_PARAM_NAME, -1 )

        setDefaultObservers()
    }

    override fun onStart() {
        super.onStart()

        if ( !viewModel.isNetworkAvailable() && viewModel.activityAction != WSL_LOGIN_ACTION_AUTO_SIGN_IN ){
            localSignIn()
            return
        }

        when( viewModel.activityAction ){
            WSL_LOGIN_ACTION_AUTO_SIGN_IN -> {
                autoSignIn()
            }
            WSL_LOGIN_ACTION_AUTO_LOG_OUT -> {
                viewModel.getLogOut {
                    intent.putExtra( WSL_FLAG_NAME, WSL_PROFILE_ANSWER_LOG_OUT)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }
            else -> {
                initFacebookSDK()
                signInWithNetworkAvailable()
            }
        }
    }

    private fun loadLoginUI() {
        this@WSLoginActivity.setContentView(R.layout.activity_login)
        progressBarCustom = WSProgressBarCustom.build(this@WSLoginActivity, progressBar = progress_bar_)
    }

    private fun setDefaultObservers() {
        viewModel.onShowProgressDialogLiveData.observe(this, Observer {
            if (!::progressBarCustom.isInitialized) return@Observer
            if (it)progressBarCustom.show() else progressBarCustom.dismiss()
        })

        viewModel.onShowErrorMessage.observe(this, Observer { message ->
            if (message == null ) return@Observer
            showSnackBarMessage(message)
            viewModel.onShowErrorMessageDone()
        })

        viewModel.onUserSignInCorrectly.observe(this, Observer {
            userLoggedCorrectly(it)
            viewModel.setOnUserSignInCorrectlyDone()
        })

        viewModel.requireRegisterUser.observe(this, Observer {
            dialogNoAccountRegistered(it)
            viewModel.setUserToRegisterDone()
        })
    }

    private fun autoSignIn(){

        viewModel.loginAuto { loginResponse ->

            if (loginResponse == null) {
                runOnUiThread {
                    loadLoginUI()
                }
                return@loginAuto
            }

            Log.e(TAG_LOGIN, "Auto login response ->$loginResponse")
            userLoggedCorrectly(loginResponse)
        }
    }

    private fun signInWithNetworkAvailable(){
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser

        if ( viewModel.tokenUser == "" && currentUser == null  ){

        }else {
            autoSignIn()
        }
    }

    @Suppress("LABEL_NAME_CLASH")
    private fun localSignIn(){

        viewModel.localSignIn { user ->
            if ( user == null ){
                viewModel.onShowErrorMessage("No se encontro usuario")
                return@localSignIn
            }
            if ( viewModel.tokenUser == "" ){
                viewModel.onShowErrorMessage("No se encontro token de usuario")
                return@localSignIn
            }
            if ( viewModel.tokenDevice == "" ){
                viewModel.onShowErrorMessage("No se encontro token de dispositivo")
                return@localSignIn
            }

            userLoggedCorrectly(LoginResponse(user=user, token = viewModel.tokenUser, message = "", auth = true))
        }
    }

    private fun userLoggedCorrectly( loginResponse: LoginResponse? = null ){

        if ( loginResponse != null ) {
            this.intent.putExtra(WSL_FLAG_NAME, WSL_LOGIN_ANSWER_SIGN_IN)
            this.intent.putExtra(WSL_ACTION_PARAM_NAME, loginResponse.user.uuid_user)
        } else {
            this.intent.putExtra(WSL_FLAG_NAME, WSL_LOGIN_ANSWER_NO_SIGN_IN)
        }

        setResult(Activity.RESULT_OK, this@WSLoginActivity.intent)
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)

        when ( requestCode ){
            RC_SIGN_IN -> {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                try {

                    val account = task.getResult(ApiException::class.java)!!
                    Log.d(TAG, TAG_LOGIN+"firebaseAuthWithGoogle:" + account.id)
                    firebaseAuth(GoogleAuthProvider.getCredential(account.idToken, null))

                } catch (e: ApiException) {
                    Log.w(TAG, TAG_LOGIN+"Google sign in failed", e)
                }
            }
        }

    }

    private fun dialogNoAccountRegistered(user: EUser? = null ){

        MaterialAlertDialogBuilder(this, R.style.ThemeOverlay_App_MaterialAlertDialog)
            .setTitle(getString(R.string.desea_crear_cuenta))
            .setMessage(getString(R.string.no_existe_cuenta_con_este_correo))
            .setNeutralButton(getString(R.string.cancel)) { _, _ -> }
            .setNegativeButton(getString(R.string.decline)) { _, _ -> }
            .setPositiveButton(getString(R.string.aceptar)) { _, _ ->
                if (user == null) return@setPositiveButton
                viewModel.onShowProgressDialog()

                viewModel.register(user) { registerResponse ->

                    if ( registerResponse == null ){
                        viewModel.onShowErrorMessage("No es posible acceder")
                        return@register
                    }

                    viewModel.onShowProgressDialogDone()

                    if ( registerResponse.uuid_user == "" ){
                        viewModel.onShowErrorMessage( registerResponse.message )
                        return@register
                    }

                    user.uuid_user = registerResponse.uuid_user
                    viewModel.tokenUser = registerResponse.token
                    viewModel.tokenDevice = user.tokendevice ?: ""

                    viewModel.saveUser( user )

                    viewModel.setUserSignInCorrectly(
                        LoginResponse(
                            user = user,
                            token = registerResponse.token,
                            message = registerResponse.message,
                            auth = true
                        )
                    )
                }
            }
            .show()
    }

    private fun firebaseAuth(credential: AuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                viewModel.requireFirebaseAuth(task)
            }
    }
}