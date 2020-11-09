package com.wsl.login.login

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.wsl.login.R
import com.wsl.login.helpers.*
import com.wsl.login.register.RegisterFragment
import com.wsl.login.login.view_model.LoginViewModel
import com.wsl.login.database.entities.EUser
import com.wsl.login.retrofit.LoginResponse
import com.wsl.login.retrofit.RegisterResponse
import com.wsl.login.helpers.buildRegisterText
import com.wsl.login.helpers.buildResource
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.editTextEmail
import kotlinx.android.synthetic.main.activity_login.email_
import kotlinx.android.synthetic.main.activity_login.progress_bar_
import javax.inject.Inject

open class WSLoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    private lateinit var progressBarCustom: ProgressBarCustom

    @Inject
    lateinit var callbackManager: CallbackManager

    @Inject
    lateinit var gso: GoogleSignInOptions

    @Inject
    lateinit var mGoogleSignInClient: GoogleSignInClient

    @Inject
    lateinit var auth: FirebaseAuth

    @Inject
    lateinit var commonUser: EUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = initDaggerViewModel()
        viewModel.activityAction = intent.getIntExtra( WSL_ACTION_PARAM_NAME, -1 )

    }

    override fun onStart() {
        super.onStart()

        viewModel.isNetworkObservable().observe( this, Observer { isAvailable ->

            if ( !isAvailable && viewModel.activityAction != WSL_LOGIN_ACTION_AUTO_SIGN_IN ){
                signInWithNetworkNoAvailable()
                return@Observer
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

        })

    }

    private fun signInWithNetworkNoAvailable(){

        viewModel.localSignIn { user ->

            if ( user == null ){
                showSnackBarMessage("No se encontro usuario")
                return@localSignIn
            }
            if ( viewModel.tokenUser == "" ){
                showSnackBarMessage("No se encontro token de usuario")
                return@localSignIn
            }
            if ( viewModel.tokenDevice == "" ){
                showSnackBarMessage("No se encontro token de dispositivo")
                return@localSignIn
            }

            userLoggedCorrectly(LoginResponse(user=user, token = viewModel.tokenUser, message = "", auth = true))

        }

    }

    private fun signInWithNetworkAvailable(){
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser

        if ( viewModel.tokenUser == "" && currentUser == null  ){

            BuildAll().run()

        }else {

            autoSignIn()

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
                    Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                    firebaseAuth(GoogleAuthProvider.getCredential(account.idToken, null))

                } catch (e: ApiException) {
                    Log.w(TAG, "Google sign in failed", e)
                }
            }
        }

    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        Log.d(TAG, "handleFacebookAccessToken:$token")
        firebaseAuth(FacebookAuthProvider.getCredential(token.token))
    }

    private fun firebaseAuth(credential: AuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                    val username = user!!.displayName
                    val email = user.email
                    val photoUrl: Uri? = user.photoUrl
                    val uid = user.uid

                    val emailVerified = auth.currentUser?.isEmailVerified

                    if ( emailVerified == null || !emailVerified ) {
                        Log.e(TAG, "signInWithCredential:failure: Email not verified" )
                        showSnackBarMessage(getString(R.string.email_not_verified))
                    }

                    if ( email == null ){

                        showSnackBarMessage(getString(R.string.email_not_verified))
                        return@addOnCompleteListener

                    }

                    /**Data from firebase*/
                    commonUser.email = email
                    commonUser.password = "wsl-services:com.wsl.login"
                    commonUser.uuid_user = uid
                    commonUser.username = username
                    commonUser.image_uri = photoUrl.toString()
                    commonUser.typeOfUser = "wsl.com.tepeheapp"
                    commonUser.tokendevice = getDeviceID()

                    loginWSL(commonUser)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
//                    Snackbar.make(t, "Authentication Failed.", Snackbar.LENGTH_SHORT).show()

                }

            }
    }

    private fun loginWSL( user: EUser){

        viewModel.login(user){ loginResponse ->

            progressBarCustom.dismiss()

            if ( loginResponse == null ){
                showSnackBarMessage(getString(R.string.intentelo_mas_tarde))
                return@login
            }

            if ( loginResponse.user.uuid_user == "" ){

                /**Register user with data provided from Google/Facebook*/
                dialogNoAccountRegistered(user){ registerResponse ->

                    if ( registerResponse == null ){
                        showSnackBarMessage("No es posible acceder")
                        return@dialogNoAccountRegistered
                    }

                    progressBarCustom.dismiss()

                    if ( registerResponse.uuid_user == "" ){
                        showSnackBarMessage( registerResponse.message )
                        return@dialogNoAccountRegistered
                    }

                    user.uuid_user = registerResponse.uuid_user
                    viewModel.tokenUser = registerResponse.token
                    viewModel.tokenDevice = user.tokendevice ?: ""

                    viewModel.saveUser( user )

                    userLoggedCorrectly(
                        LoginResponse(
                            user = user,
                            token = registerResponse.token,
                            message = registerResponse.message,
                            auth = true
                        )
                    )

                }

                return@login

            }

            viewModel.tokenUser = loginResponse.token
            viewModel.tokenDevice = user.tokendevice ?: ""
            viewModel.saveUser(loginResponse.user)

            userLoggedCorrectly(loginResponse)

        }

    }

    private fun autoSignIn(){

        viewModel.loginAuto { loginResponse ->

            if (loginResponse == null) {

                if( viewModel.activityAction == WSL_LOGIN_ACTION_AUTO_SIGN_IN ){
                    userLoggedCorrectly()
                    return@loginAuto
                }

                BuildAll().run()
                return@loginAuto
            }

            Log.e("login response", loginResponse.toString())

            userLoggedCorrectly(loginResponse)

        }
    }

    private fun dialogNoAccountRegistered(userToRegister: EUser? = null, function: (RegisterResponse?) -> Unit ){

        MaterialAlertDialogBuilder(this, R.style.ThemeOverlay_App_MaterialAlertDialog)
            .setTitle(getString(R.string.desea_crear_cuenta))
            .setMessage(getString(R.string.no_existe_cuenta_con_este_correo))
            .setNeutralButton(getString(R.string.cancel)) { dialog, which ->
                // Respond to neutral button press
                function(null)
            }
            .setNegativeButton(getString(R.string.decline)) { dialog, which ->
                // Respond to negative button press

                function(null)
            }
            .setPositiveButton(getString(R.string.aceptar)) { dialog, which ->

                if (userToRegister == null) {
                    return@setPositiveButton
                }

                progressBarCustom.show()

                viewModel.register(userToRegister, function)
            }
            .show()

    }

    private inner class BuildAll: Thread(){

        override fun run() {
            super.run()

            this@WSLoginActivity.setContentView(R.layout.activity_login)

            iconView.buildResource( R.mipmap.wsl_logo, applicationContext )

            progressBarCustom = ProgressBarCustom.build(this@WSLoginActivity, progress_bar_)
            progressBarCustom.show()

            initButtons()

            progressBarCustom.dismiss()

        }

        private fun initButtons(){

            findViewById<Button>(R.id.iniciar_sesion)?.setOnClickListener { buttonView ->

                /**This is just to show the email and password field*/
                if ( email_?.visibility == View.GONE ) {

                    iniciar_sesion.text = getString(R.string.iniciar_sesion)
                    email_?.visibility = View.VISIBLE
                    passwordLayout?.visibility = View.VISIBLE
                    return@setOnClickListener

                }

                /**Here is when the user click on sign in*/
                progressBarCustom.show()

                val email = editTextEmail?.text.toString()
                val password = extiTextPassword?.text.toString()

//                val email = "develop.wsl0@gmail.com"
//                val password = "12345"

                if ( email == "" ){

                    editTextEmail?.requestFocus()
                    editTextEmail?.error = "Es necesario este campo"
                    progressBarCustom.dismiss()
                    return@setOnClickListener

                }
                if ( !email.contains("@") ){

                    editTextEmail?.requestFocus()
                    editTextEmail?.error = "El formato del correo es invalido."
                    progressBarCustom.dismiss()
                    return@setOnClickListener

                }
                if ( password == "" ){

                    extiTextPassword?.requestFocus()
                    extiTextPassword?.error = "El password es requerido"
                    progressBarCustom.dismiss()
                    return@setOnClickListener

                }
                if ( password.length < 3 ){

                    extiTextPassword?.requestFocus()
                    extiTextPassword?.error = "El campo debe tener mas de 3 caracteres"
                    progressBarCustom.dismiss()
                    return@setOnClickListener

                }

                commonUser.email = email
                commonUser.password = password

                loginWSL( commonUser )

            }

            buildRegisterText( registrarme ).setOnClickListener {

                val dialog = RegisterFragment()
                val ft = supportFragmentManager.beginTransaction()
                dialog.show(ft, RegisterFragment.TAG)

            }


            findViewById<LoginButton>(R.id.facebook_login_).setReadPermissions("email")
            findViewById<LoginButton>(R.id.facebook_login_)
                .registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
                    override fun onSuccess(loginResult: LoginResult) {
                        Log.d(TAG, "facebook:onSuccess:$loginResult")
                        handleFacebookAccessToken(loginResult.accessToken)
                    }

                    override fun onCancel() {
                        Log.d(TAG, "facebook:onCancel")
                        // ...
                    }

                    override fun onError(error: FacebookException) {
                        Log.d(TAG, "facebook:onError", error)
                        // ...
                    }
                })

            google_login_.setOnClickListener {
                val signInIntent = mGoogleSignInClient.signInIntent
                startActivityForResult(signInIntent, RC_SIGN_IN)
            }
        }

    }

}