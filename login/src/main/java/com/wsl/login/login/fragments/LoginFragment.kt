package com.wsl.login.login.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.*
import com.wsl.login.R
import com.wsl.login.database.entities.EUser
import com.wsl.login.databinding.LoginFragmentBinding
import com.wsl.login.helpers.*
import com.wsl.login.login.TAG_LOGIN
import com.wsl.login.login.WSLoginActivity
import com.wsl.login.login.view_model.WSLoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
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

    private val googleSignInActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {

            val account = task.getResult(ApiException::class.java)!!
            Log.d(TAG, TAG_LOGIN+"firebaseAuthWithGoogle:" + account.id)
            firebaseAuth(GoogleAuthProvider.getCredential(account.idToken, null))

        } catch (e: ApiException) {
            Log.w(TAG, TAG_LOGIN+"Google sign in failed", e)
        }
    }

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
        callbackManager = (activity as WSLoginActivity).callbackManager
        loadButtonsClickListener()
        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    private fun requireFirebaseAuth(task: Task<AuthResult>?) {
        if (task == null) return

        viewModel.isTrackingAppOut = false
        if (task.isSuccessful) {
            // Sign in success, update UI with the signed-in user's information
            Log.d(TAG, "signInWithCredential:success")
            val user = auth.currentUser
            val username = user!!.displayName
            var email = user.email
            val photoUrl: Uri? = user.photoUrl
            val uid = user.uid

            val emailVerified = auth.currentUser?.isEmailVerified

            //TODO: crear metodos para verificar el correo
            if ( emailVerified == null || !emailVerified ) {
                auth.currentUser?.sendEmailVerification()
                Log.e(TAG, "signInWithCredential:failure: Email not verified" )
                user.providerData.forEach { provider ->
                    if (provider.email != null)
                        email = provider.email
                }
            }

            if ( email == null ){
                viewModel.onShowErrorMessage(getString(R.string.email_not_verified))
                return
            }

            /**Data from firebase*/
            val commonUser = EUser(
                uuid_user= UUID.randomUUID().toString(),
                email = email,
                password = "wsl-services:com.wsl.login",
                google_uid = uid,
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

        }
    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        Log.d(TAG, TAG_LOGIN +"handleFacebookAccessToken:$token")
        firebaseAuth(FacebookAuthProvider.getCredential(token.token))
    }

    private fun loginWSL(user: EUser){

        viewModel.login(user){ loginResponse ->

            if ( loginResponse == null ){
                viewModel.onShowErrorMessage(getString(R.string.intentelo_mas_tarde))
                return@login
            }

            if ( loginResponse.uuid_user == "" ){
                /**Register user with data provided from Google/Facebook*/
                viewModel.setUserToRegister(user)
                return@login
            }

            viewModel.tokenDevice = user.tokendevice ?: context?.getDeviceID() ?: ""
            viewModel.userID = user.uuid_user
            viewModel.saveUserOrUpdate(loginResponse)

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

        binding.facebookLogin.setPermissions(listOf("email"))
        binding.facebookLogin.fragment = this
        binding.facebookLogin.setOnClickListener {
            viewModel.isTrackingAppOut = true
        }
        LoginManager.getInstance().registerCallback(callbackManager, object: FacebookCallback<LoginResult> {
            override fun onCancel() {
                Log.d(TAG, "onCancel")
            }

            override fun onError(error: FacebookException) {
                Log.d(TAG, "onError ${error.stackTrace}")
            }

            override fun onSuccess(result: LoginResult) {
                Log.d(TAG, "Result: $result")
                result.let { handleFacebookAccessToken(it.accessToken) }
            }
        })

        binding.googleLogin.setOnClickListener {
            viewModel.isTrackingAppOut = true
            val signInIntent = mGoogleSignInClient.signInIntent
            googleSignInActivityResult.launch(signInIntent)
        }
    }

    private fun firebaseAuth(credential: AuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                requireFirebaseAuth(task)
            }
    }

}