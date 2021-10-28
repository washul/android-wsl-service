package com.wsl.login.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.facebook.CallbackManager
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.wsl.login.R
import com.wsl.login.config.Config
import com.wsl.login.database.entities.EUser
import com.wsl.login.helpers.*
import com.wsl.login.login.view_model.WSLoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.wsl.login.databinding.ActivityLoginBinding

const val TAG_LOGIN = "WSLoginActivity "
@AndroidEntryPoint
class WSLoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var callbackManager: CallbackManager

    @Inject
    lateinit var viewModel: WSLoginViewModel

    @Inject
    lateinit var gso: GoogleSignInOptions

    @Inject
    lateinit var mGoogleSignInClient: GoogleSignInClient

    @Inject
    lateinit var auth: FirebaseAuth

    @Inject
    lateinit var configClass: Config

    private lateinit var progressBarCustom: WSProgressBarCustom

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        viewModel.activityAction = intent.getIntExtra( WSL_ACTION_PARAM_NAME, -1 )
        viewModel.setConfigFile( configClass.readConfigFile() )

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
                if (!viewModel.isTrackingAppOut)
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
//                initFacebookSDK()
                signInWithNetworkAvailable()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private fun loadLoginUI() {
        this@WSLoginActivity.setContentView(binding.root)
        progressBarCustom = WSProgressBarCustom.build(this@WSLoginActivity, progressBar = binding.progressBar)
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
            if(it == null) return@Observer

            userLoggedCorrectly(it.uuid_user)
            viewModel.setOnUserSignInCorrectlyDone()
        })

        viewModel.requireRegisterUser.observe(this, Observer {
            dialogNoAccountRegistered(it)
            viewModel.setUserToRegisterDone()
        })
    }

    private fun autoSignIn(){
        viewModel.loginAuto { userID ->
            if(userID == null) {
                logOut()
                runOnUiThread {loadLoginUI()}
                return@loginAuto
            }

            Log.e(TAG_LOGIN, "Auto login response ->$userID")
            userLoggedCorrectly(userID)
        }
    }

    private fun signInWithNetworkAvailable(){
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser

        if ( viewModel.tokenUser == "" && currentUser == null  ){
            runOnUiThread { loadLoginUI() }
        }else {
            if (!viewModel.isTrackingAppOut)
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

            userLoggedCorrectly(user.uuid_user)
        }
    }

    private fun userLoggedCorrectly(userID: String? = null ){

        if ( userID != null ) {
            this.intent.putExtra(WSL_FLAG_NAME, WSL_LOGIN_ANSWER_SIGN_IN)
            this.intent.putExtra(WSL_ACTION_PARAM_NAME, userID)
        } else {
            this.intent.putExtra(WSL_FLAG_NAME, WSL_LOGIN_ANSWER_NO_SIGN_IN)
        }

        setResult(Activity.RESULT_OK, this@WSLoginActivity.intent)
        finish()
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

                    viewModel.saveUserOrUpdate( user )

                    viewModel.setUserSignInCorrectly(user)
                }
            }
            .show()
    }

    private fun logOut() {
        viewModel.logOut()
    }
}