package wsl.com.tepeheapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputLayout
import com.wsl.login.R
import com.wsl.login.model.EUser
import com.wsl.login.view_model.LoginViewModel
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    private var UIView: View? = null

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle? ): View? {

        UIView = inflater.inflate(R.layout.fragment_register, container, false)

        BuildAll().run()

        return UIView

    }

    private inner class BuildAll: Thread(){

//        MARK: OBJECTS
        private lateinit var loginViewModel: LoginViewModel

//        MARK: UI
        private var holder_name = UIView?.findViewById<TextInputLayout>( R.id.holder_name )
        private var last_name = UIView?.findViewById<TextInputLayout>( R.id.last_name )
        private var email       = UIView?.findViewById<TextInputLayout>( R.id.emailLayout )
        private var country_    = UIView?.findViewById<TextInputLayout>( R.id.country_ )
        private var state_      = UIView?.findViewById<TextInputLayout>( R.id.state_ )
        private var city_       = UIView?.findViewById<TextInputLayout>( R.id.city_ )
        private var phone_      = UIView?.findViewById<TextInputLayout>( R.id.phone_ )
        private var first       = UIView?.findViewById<RadioButton>( R.id.first )

        override fun run() {
            super.run()

            this.loginViewModel = ViewModelProviders
                .of( this@RegisterFragment )
                .get( LoginViewModel::class.java )

            UIView?.findViewById<Button>( R.id.registrarse_ )?.setOnClickListener {

                //Validate text fields
                if ( !validateAllFields() )
                    returnTransition

//                Send to register on the cloud
                loginViewModel.register( getUser() ){

                    if ( !it ){
//                        TODO: message to not register user
                        return@register
                    }

                    activity?.onBackPressed()

                }

            }

        }

        private fun validateAllFields(): Boolean {

            if ( holder_name?.editText?.text.toString() == "" ) {
                holder_name?.error = getString(R.string.campo_requerido)
                return false
            }else{
                holder_name?.error = null
            }

            if ( last_name?.editText?.text.toString() == "" ) {
                last_name?.error = getString(R.string.campo_requerido)
                return false
            }else{
                last_name?.error = null
            }

            when {
                email?.editText?.text.toString() == "" -> {
                    email?.error = getString(R.string.campo_requerido)
                    return false
                }
                !email?.editText?.text.toString().contains("@") -> {
                    email?.error = getString(R.string.correo_no_valido)
                    return false
                }
                else -> {
                    email?.error = null
                }
            }

            if ( country_?.editText?.text.toString() == "" ){
                country_?.error = getString(R.string.campo_requerido)
                return false
            }else{
                country_?.error = ""
            }
            if ( state_?.editText?.text.toString() == "" ){
                state_?.error = getString(R.string.campo_requerido)
                return false
            }else{
                state_?.error = ""
            }
            if ( city_?.editText?.text.toString() == "" ){
                city_?.error = getString(R.string.campo_requerido)
                return false
            }else{
                city_?.error = ""
            }

            when {
                phone_?.editText?.text.toString() == "" -> {
                    phone_?.error = getString(R.string.campo_requerido)
                    return false
                }
                phone_?.editText?.text.toString().length < 8 -> {
                    phone_?.error = getString(R.string.telefono_no_valido)
                    return false
                }
                else -> {
                    phone_?.error = ""
                }
            }


            when {
                passwordLayout1?.editText?.text.toString() == "" -> {
                    passwordLayout1?.error = getString(R.string.campo_requerido)
                    return false
                }
                passwordLayout1?.editText?.text.toString().length < 8 -> {
                    passwordLayout1?.error = getString(R.string.contraseña_8_caracteres)
                    return false
                }
                passwordLayout1?.editText?.text.toString() != passwordLayout2?.editText?.text.toString() -> {
                    passwordLayout2?.error = getString(R.string.password_debe_ser_similar)
                }
                else -> {
                    passwordLayout1?.error = ""
                }
            }

            return true
        }

        private fun getUser(): EUser {

            val name        = holder_name?.editText?.text.toString()
            val last_name   = last_name?.editText?.text.toString()
            val email       = email?.editText?.text.toString()
            val country     = country_?.editText?.text.toString()
            val state       = state_?.editText?.text.toString()
            val city        = city_?.editText?.text.toString()
            val phone       = phone_?.editText?.text.toString()
            val password    = passwordLayout1?.editText?.text.toString()
            val sex         = if (first?.isSelected!!) "1" else "2"

            return EUser(
                uuid= "0",
                name= name,
                last_name = last_name,
                email= email,
                country= country,
                state= state,
                city= city,
                phone= phone,
                sex= sex,
                typeOfUser= "wsl.com.tepeheapp",
                password= password )

        }

    }


}
