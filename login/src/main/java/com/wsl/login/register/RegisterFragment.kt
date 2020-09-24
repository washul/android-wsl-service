package com.wsl.login.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputLayout
import com.wsl.login.R
import com.wsl.login.helpers.ProgressBarCustom
import com.wsl.login.helpers.getDeviceID
import com.wsl.login.helpers.showSnackBarMessage
import com.wsl.login.view_model.LoginViewModel
import com.wsl.utils.database.EUser
import kotlinx.android.synthetic.main.fragment_register.*
import java.util.*

class RegisterFragment : DialogFragment() {

    private var UIView: View? = null

    companion object {
        const val TAG = "RegisterFragment"
    }

    override fun onStart() {
        super.onStart()

        val dialog = dialog

        if ( dialog != null ) {

            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window?.setLayout(width, height)

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)

    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle? ): View? {

        UIView = inflater.inflate(R.layout.fragment_register, container, false)

        BuildAll().run()

        return UIView

    }

    private inner class BuildAll: Thread(){

//        MARK: OBJECTS
        private lateinit var loginViewModel: LoginViewModel


//        MARK: UI OBJECTS
        private val progress_bar_ = UIView?.findViewById<ProgressBar>( R.id.progress_bar_)
        private val holder_name = UIView?.findViewById<TextInputLayout>( R.id.holder_name)
        private val last_name = UIView?.findViewById<TextInputLayout>( R.id.last_name)
        private val email = UIView?.findViewById<TextInputLayout>( R.id.email_)
        private val passwordLayout1 = UIView?.findViewById<TextInputLayout>( R.id.passwordLayout1)
        private val passwordLayout2 = UIView?.findViewById<TextInputLayout>( R.id.passwordLayout2)
        private val country_ = UIView?.findViewById<TextInputLayout>( R.id.country_)
        private val state_ = UIView?.findViewById<TextInputLayout>( R.id.state_)
        private val city_ = UIView?.findViewById<TextInputLayout>( R.id.city_)
        private val phone_ = UIView?.findViewById<TextInputLayout>( R.id.phone_)
        private val registrarse_ = UIView?.findViewById<Button>( R.id.registrarse_)


        private lateinit var progressBarCustom: ProgressBarCustom

        override fun run() {
            super.run()

            progressBarCustom = ProgressBarCustom.build( activity!!, progress_bar_!! )
            progressBarCustom.show()

//            Tmp just for testing
            holder_name?.editText?.setText( "Alejandro" )
            last_name?.editText?.setText( "Carrillo" )
            email?.editText?.setText( "develop.wsl5@gmail.com" )
            passwordLayout1?.editText?.setText( "12345678" )
            passwordLayout2?.editText?.setText( "12345678" )
            country_?.editText?.setText( "Mexico" )
            state_?.editText?.setText( "Jalisco" )
            city_?.editText?.setText( "Zapopan" )
            phone_?.editText?.setText( "1234567890" )

            this.loginViewModel = ViewModelProviders
                .of( this@RegisterFragment )
                .get( LoginViewModel()::class.java )
                .apply {
//                    this.repository = RepositoryLogin.build( context!! )
//                    this.prefs = Preferences( context!! )
                }

            loginViewModel.userRegister.observe( this@RegisterFragment, Observer { user ->

//                temps just for testing
                user.uuid = UUID.randomUUID().toString()

//                Send to register on the cloud
                loginViewModel.register( user ){ registerResponse ->

                    progressBarCustom.dismiss()

                    if ( registerResponse == null ){
                        UIView?.showSnackBarMessage( getString(R.string.intentelo_mas_tarde) )
                        return@register
                    }

                    if ( registerResponse.uuid == "0" ){
                        UIView?.showSnackBarMessage( registerResponse.message )
                        return@register
                    }

                    user.uuid = registerResponse.uuid
                    loginViewModel.tokenUser = registerResponse.token

                    loginViewModel.saveUser( user )

                    activity?.onBackPressed()

                }

            })

            initRegisterButton()

            progressBarCustom.dismiss()

        }

        private fun initRegisterButton(){

            registrarse_?.setOnClickListener { _ ->
                
                first?.isSelected = true

                progressBarCustom.show()

                //Validate text fields
                if ( !validateAllFields() )
                    returnTransition

                loginViewModel.userRegister.value = getUser()

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
                tokendevice = context?.getDeviceID(),
                password= password )

        }

    }


}
