package wsl.com.tepeheapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso
import com.wsl.login.R
import com.wsl.login.changeImageTo
import com.wsl.login.model.EUser
import com.wsl.login.view_model.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private var UIView: View? = null
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle? ): View? {

        UIView = inflater.inflate(R.layout.fragment_login, container, false)

        this.loginViewModel = ViewModelProviders
            .of( this@LoginFragment )
            .get( LoginViewModel::class.java )

        BuildAll().run()

        return UIView

    }

    private inner class BuildAll: Thread(){

        private val piccaso = Picasso.with( context )
        private val facebook_ = UIView?.findViewById<ImageView>(R.id.facebook_login_)
        private val instagram_ = UIView?.findViewById<ImageView>(R.id.instagram_login_)
        private val google_ = UIView?.findViewById<ImageView>(R.id.google_login_)

        override fun run() {
            super.run()

            facebook_?.changeImageTo( R.drawable.facebook, piccaso )
            instagram_?.changeImageTo( R.drawable.instagram, piccaso )
            google_?.changeImageTo( R.drawable.google, piccaso )

            UIView?.findViewById<Button>( R.id.iniciar_sesion)?.setOnClickListener {

////                TODO: TEMPORAL!!!!!
//                findNavController().navigate(LoginFragmentDirections.toGridContentFragment())
//                return@setOnClickListener

                if ( emailLayout?.visibility == View.GONE ) {

                    iniciar_sesion.text = getString(R.string.iniciar_sesion)
                    emailLayout?.visibility = View.VISIBLE
                    passwordLayout?.visibility = View.VISIBLE
                    return@setOnClickListener

                }

                val email = editTextEmail?.text.toString()
                val password = extiTextPassword?.text.toString()

                if ( email == "" ){

                    editTextEmail?.requestFocus()
                    editTextEmail?.error = "Es necesario este campo"
                    return@setOnClickListener

                }
                if ( !email.contains("@") ){

                    editTextEmail?.requestFocus()
                    editTextEmail?.error = "El formato del correo es invalido."
                    return@setOnClickListener

                }
                if ( password == "" ){

                    extiTextPassword?.requestFocus()
                    extiTextPassword?.error = "El password es requerido"
                    return@setOnClickListener

                }
                if ( password.length < 3 ){

                    extiTextPassword?.requestFocus()
                    extiTextPassword?.error = "El campo debe tener mas de 3 caracteres"
                    return@setOnClickListener

                }

                loginViewModel.login( EUser(uuid = "0", email = email, password = password ) ){ userResponse ->

//                    if ( userResponse == null ){ THIS IS THE CORRECT SENTENCE
                    if ( userResponse != null ){
                        extiTextPassword?.error = "Contraseña incorrecta"
                        return@login
                    }

//                    TODO: Save the new user from backend on the local storage

//                    findNavController().navigate(LoginFragmentDirections.toGridContentFragment())


                }


            }

            UIView?.findViewById<Button>( R.id.registrarme )?.setOnClickListener {

//                findNavController().navigate(LoginFragmentDirections.toRegusterFragment())

            }

        }

    }

}
