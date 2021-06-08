package com.wsl.login.login.fragments

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.wsl.login.R
import com.wsl.login.database.entities.EUser
import com.wsl.login.databinding.LoginFragmentBinding
import com.wsl.login.helpers.*
import com.wsl.login.login.TAG_LOGIN
import com.wsl.login.login.view_model.WSLoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment: Fragment()  {

    @Inject
    lateinit var callbackManager: CallbackManager

    @Inject
    lateinit var gso: GoogleSignInOptions

    @Inject
    lateinit var mGoogleSignInClient: GoogleSignInClient

    @Inject
    lateinit var auth: FirebaseAuth

    @Inject
    lateinit var viewModel: WSLoginViewModel

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )

        context?.let { binding.iconView.buildResource( R.mipmap.ic_logo, it) }
        setDefaultObservers()
        loadButtonsClickListener()
        return binding.root
    }

    private fun setDefaultObservers() {
        viewModel.requireFirebaseAuthLiveData.observe(viewLifecycleOwner, Observer { task ->
            if (task == null) return@Observer

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
                    viewModel.onShowErrorMessage(getString(R.string.email_not_verified))
                }

                if ( email == null ){

                    viewModel.onShowErrorMessage(getString(R.string.email_not_verified))
                    return@Observer

                }

                /**Data from firebase*/
                val commonUser = EUser(
                    email = email,
                    password = "wsl-services:com.wsl.login",
                    uuid_user = uid,
                    username = username,
                    image_uri = photoUrl.toString(),
                    typeOfUser = "wsl.com.tepeheapp",
                    tokendevice = context?.getDeviceID()
                )
                viewModel.commonUser = commonUser
                viewModel.setUser(commonUser)
                loginWSL(commonUser)

            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithCredential:failure", task.exception)
//                    Snackbar.make(t, "Authentication Failed.", Snackbar.LENGTH_SHORT).show()

            }

            viewModel.requireFirebaseAuthDone()
        })
    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        Log.d(TAG, TAG_LOGIN +"handleFacebookAccessToken:$token")
//        firebaseAuth(FacebookAuthProvider.getCredential(token.token))
    }

    private fun loginWSL(user: EUser){

        viewModel.login(user){ loginResponse ->

            if ( loginResponse == null ){
                viewModel.onShowErrorMessage(getString(R.string.intentelo_mas_tarde))
                return@login
            }

            if ( loginResponse.user.uuid_user == "" ){
                /**Register user with data provided from Google/Facebook*/
                viewModel.setUserToRegister(user)
                return@login
            }

            viewModel.tokenUser = loginResponse.token
            viewModel.tokenDevice = user.tokendevice ?: context?.getDeviceID() ?: ""
            viewModel.saveUser(loginResponse.user)

            viewModel.setUserSignInCorrectly(loginResponse)
            viewModel.onShowProgressDialogDone()
        }

    }

    private fun loadButtonsClickListener(){

        binding.iniciarSesion.setOnClickListener { buttonView ->

            /**This is just to show the email and password field*/
            if ( binding.email.visibility == View.GONE ) {

                binding.iniciarSesion.text = getString(R.string.iniciar_sesion)
                binding.email.visibility = View.VISIBLE
                binding.passwordLayout.visibility = View.VISIBLE
                binding.email.editText?.requestFocusToWrite()
                return@setOnClickListener

            }

            /**Here is when the user click on sign in*/
            viewModel.onShowProgressDialog()

            val editTextEmail = binding.editTextEmail
            val extiTextPassword = binding.extiTextPassword

            val email = editTextEmail.text.toString()
            val password = extiTextPassword.text.toString()

//                val email = "develop.wsl0@gmail.com"
//                val password = "12345"

            if ( email == "" ){
                editTextEmail.requestFocus()
                editTextEmail.error = "Es necesario este campo"
                viewModel.onShowProgressDialogDone()
                return@setOnClickListener
            }
            if ( !email.contains("@") ){
                editTextEmail.requestFocus()
                editTextEmail.error = "El formato del correo es invalido."
                viewModel.onShowProgressDialogDone()
                return@setOnClickListener
            }
            if ( password == "" ){
                extiTextPassword.requestFocus()
                extiTextPassword.error = "El password es requerido"
                viewModel.onShowProgressDialogDone()
                return@setOnClickListener
            }
            if ( password.length < 3 ){
                extiTextPassword.requestFocus()
                extiTextPassword.error = "El campo debe tener mas de 3 caracteres"
                viewModel.onShowProgressDialogDone()
                return@setOnClickListener
            }

            viewModel.commonUser.email = email
            viewModel.commonUser.password = password

            loginWSL( viewModel.commonUser )

        }

        binding.registrarme.useAsRegisterButton().setOnClickListener {
            viewModel.onShowProgressDialog()
            this.findNavController().navigate(LoginFragmentDirections.loginFragmentToRegisterFragment())
        }

//            findViewById<LoginButton>(R.id.facebook_login_).setPermissions(listOf("email"))
//            findViewById<LoginButton>(R.id.facebook_login_)
//                .registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
//                    override fun onSuccess(loginResult: LoginResult) {
//                        Log.d(TAG, "facebook:onSuccess:$loginResult")
//                        handleFacebookAccessToken(loginResult.accessToken)
//                    }
//
//                    override fun onCancel() {
//                        Log.d(TAG, "facebook:onCancel")
//                        // ...
//                    }
//
//                    override fun onError(error: FacebookException) {
//                        Log.d(TAG, "facebook:onError", error)
//                        // ...
//                    }
//                })

        binding.googleLogin.setOnClickListener {
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
    }

}