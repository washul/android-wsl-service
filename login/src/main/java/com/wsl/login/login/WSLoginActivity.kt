package com.wsl.login.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
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
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.squareup.picasso.Picasso
import com.wsl.login.R
import com.wsl.login.helpers.*
import com.wsl.login.register.RegisterFragment
import com.wsl.login.login.view_model.LoginViewModel
import com.wsl.login.database.EUser
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class WSLoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

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

        initFacebookSDK()
        loginViewModel = initDaggerViewModel()

        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser

        if ( loginViewModel.tokenUser == "" && currentUser == null  ){

            BuildAll().run()

        }else {

            loginViewModel.loginAuto { loginResponse ->

                if (loginResponse == null) {

                    BuildAll().run()
                    return@loginAuto
                }

                Log.e("login response", loginResponse.toString())

                userLoggedCorrectly(loginResponse.user.uuid_user)

            }

        }

    }

    private fun userLoggedCorrectly(uuid: String){
        this@WSLoginActivity.intent.putExtra("uuid", uuid)
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
//                    val name = user!!.displayName
                    val email = user?.email
//                    val photoUrl: Uri? = user.photoUrl

                    email?.let { loginWSL(it, user.providerId, true ) }

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
//                    Snackbar.make(t, "Authentication Failed.", Snackbar.LENGTH_SHORT).show()

                }

            }
    }

    private fun loginWSL( email: String, password: String, isExternalLogin: Boolean = false, viewToError: View? = null ){

        if ( isExternalLogin ){

//            TODO: hacer el metodo para logearse sin password

        }

        loginViewModel.login(EUser(uuid_user = "", email = email, password = password)){ loginResponse ->

//            progressBarCustom.dismiss()

            if ( loginResponse == null ){
                viewToError?.showSnackBarMessage(getString(R.string.intentelo_mas_tarde))
                return@login
            }

            loginViewModel.tokenUser = loginResponse.token
            loginViewModel.saveUser(loginResponse.user)

            viewToError?.showSnackBarMessage(loginResponse.message)

            userLoggedCorrectly(loginResponse.user.uuid_user)

        }

    }



    private inner class BuildAll: Thread(){

        private val piccaso = Picasso.with(this@WSLoginActivity)
        private lateinit var progressBarCustom: ProgressBarCustom

        override fun run() {
            super.run()

            this@WSLoginActivity.setContentView(R.layout.activity_login)

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

//                val email = editTextEmail?.text.toString()
//                val password = extiTextPassword?.text.toString()

                val email = "develop.wsl0@gmail.com"
                val password = "12345"

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

                loginWSL( email, password )

            }

            findViewById<Button>(R.id.registrarme)?.setOnClickListener {

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