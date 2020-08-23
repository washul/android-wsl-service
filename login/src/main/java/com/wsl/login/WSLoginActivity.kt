package com.wsl.login

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import com.wsl.login.helpers.Preferences
import com.wsl.login.helpers.ProgressBarCustom
import com.wsl.login.helpers.changeImageTo
import com.wsl.login.helpers.showSnackBarMessage
import com.wsl.login.model.EUser
import com.wsl.login.register.RegisterFragment
import com.wsl.login.view_model.LoginViewModel
import com.wsl.login.view_model.RepositoryLogin
import kotlinx.android.synthetic.main.activity_login.*

class WSLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        BuildAll().run()
    }

    private inner class BuildAll: Thread(){

        private lateinit var loginViewModel: LoginViewModel
        private val piccaso = Picasso.with( this@WSLoginActivity )
        private lateinit var progressBarCustom: ProgressBarCustom

        override fun run() {
            super.run()

            progressBarCustom = ProgressBarCustom.build( this@WSLoginActivity, progress_bar_ )
            progressBarCustom.show()

            this.loginViewModel = ViewModelProviders
                .of( this@WSLoginActivity )
                .get( LoginViewModel()::class.java )
                .apply {
                    this.repository = RepositoryLogin.build( applicationContext )
                    this.prefs = Preferences( applicationContext )
                }

            facebook_login_?.changeImageTo( R.drawable.facebook, piccaso )
            instagram_login_?.changeImageTo( R.drawable.instagram, piccaso )
            google_login_?.changeImageTo( R.drawable.google, piccaso )

            findViewById<Button>( R.id.iniciar_sesion)?.setOnClickListener { buttonView ->

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

                val email = "develop.wsl@gmail.com"
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

                loginViewModel.login( EUser(uuid = "", email = email, password = password ) ){ loginResponse ->

                    progressBarCustom.dismiss()

                    if ( loginResponse == null ){
                        buttonView.showSnackBarMessage( getString(R.string.intentelo_mas_tarde) )
                        return@login
                    }

                    loginViewModel.prefs.tokenUser = loginResponse.token
                    loginViewModel.saveUser( loginResponse.user )

                    buttonView.showSnackBarMessage( loginResponse.message )

                    this@WSLoginActivity.intent.putExtra("uuid", loginResponse.user.uuid )
                    setResult( Activity.RESULT_OK,  this@WSLoginActivity.intent )
                    finish()

                }

            }

            findViewById<Button>( R.id.registrarme )?.setOnClickListener {

                val dialog = RegisterFragment()
                val ft = supportFragmentManager.beginTransaction()
                dialog.show(ft, RegisterFragment.TAG)

            }

            progressBarCustom.dismiss()

        }

    }

}