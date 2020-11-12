package com.wsl.login.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputLayout
import com.wsl.login.R
import com.wsl.login.helpers.ProgressBarCustom
import com.wsl.login.helpers.getDeviceID
import com.wsl.login.helpers.showSnackBarMessage
import com.wsl.login.database.entities.EUser
import com.wsl.login.profile.view_model.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_register.*

class UpdateProfileFragment : DialogFragment() {

    private var UIView: View? = null

    companion object {
        const val TAG = "UpdateProfileFragment"
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
        private lateinit var profileViewModel: ProfileViewModel


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
        private val address_ = UIView?.findViewById<TextInputLayout>( R.id.address_)
        private val phone_ = UIView?.findViewById<TextInputLayout>( R.id.phone_)
        private val registrarse_ = UIView?.findViewById<Button>( R.id.registrarse_)
        private val first = UIView?.findViewById<RadioButton>( R.id.first)
        private val second = UIView?.findViewById<RadioButton>( R.id.second)


        private lateinit var progressBarCustom: ProgressBarCustom

        override fun run() {
            super.run()

            progressBarCustom = ProgressBarCustom.build( activity!!, progressBar = progress_bar_!! )
            progressBarCustom.show()

            this.profileViewModel = ( activity!! as ProfileActivity ).viewModel

//            Tmp just for testing
            holder_name?.editText?.setText( profileViewModel.user.name )
            last_name?.editText?.setText( profileViewModel.user.last_name )
            email?.editText?.setText( profileViewModel.user.email )
            passwordLayout1?.visibility = View.GONE
            passwordLayout2?.visibility = View.GONE
            country_?.editText?.setText( profileViewModel.user.country )
            state_?.editText?.setText( profileViewModel.user.state )
            city_?.editText?.setText( profileViewModel.user.city )
            address_?.editText?.setText( profileViewModel.user.address )
            phone_?.editText?.setText( profileViewModel.user.phone )
            if ( profileViewModel.user.sex != null ) {
                when (profileViewModel.user.sex) {
                    "1" -> first?.isSelected = true
                    "2" -> second?.isChecked = true
                    else -> {
                        first?.isSelected = false
                        second?.isSelected = false
                        first?.isChecked = false
                        second?.isChecked = false
                    }
                }
            }else{
                first?.isSelected = false
                first?.isChecked = false
                second?.isSelected = false
                second?.isChecked = false
            }

            email?.editText?.isEnabled = false

            profileViewModel.userUpdate.observe( this@UpdateProfileFragment, Observer { user ->

                user.uuid_user = profileViewModel.user.uuid_user

//                Send to update on the cloud
                profileViewModel.updateUser( user ){ registerResponse ->

                    progressBarCustom.dismiss()

                    if ( registerResponse == null ){
                        UIView?.showSnackBarMessage( getString(R.string.intentelo_mas_tarde) )
                        return@updateUser
                    }

                    if ( registerResponse.uuid_user == "0" ){
                        UIView?.showSnackBarMessage( registerResponse.message )
                        return@updateUser
                    }

                    if ( registerResponse.token != null && registerResponse.token != "" )
                        profileViewModel.tokenUser = registerResponse.token

                    profileViewModel.saveUser( user )
                    profileViewModel.getUserLocalAsync {
                        profileViewModel.userMutable.value = it
                    }

                    this@UpdateProfileFragment.dismiss()

                }

            })

            initRegisterButton()

            progressBarCustom.dismiss()

        }

        private fun initRegisterButton(){

            registrarse_?.text = getString(R.string.save)
            registrarse_?.setOnClickListener { _ ->
                
                first?.isSelected = true

                progressBarCustom.show()

                //Validate text fields
                if ( !validateAllFields() )
                    returnTransition

                profileViewModel.userUpdate.value = getUser()

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

//            if ( country_?.editText?.text.toString() == "" ){
//                country_?.error = getString(R.string.campo_requerido)
//                return false
//            }else{
//                country_?.error = ""
//            }
//            if ( state_?.editText?.text.toString() == "" ){
//                state_?.error = getString(R.string.campo_requerido)
//                return false
//            }else{
//                state_?.error = ""
//            }
//            if ( city_?.editText?.text.toString() == "" ){
//                city_?.error = getString(R.string.campo_requerido)
//                return false
//            }else{
//                city_?.error = ""
//            }
//
//            when {
//                phone_?.editText?.text.toString() == "" -> {
//                    phone_?.error = getString(R.string.campo_requerido)
//                    return false
//                }
//                phone_?.editText?.text.toString().length < 8 -> {
//                    phone_?.error = getString(R.string.telefono_no_valido)
//                    return false
//                }
//                else -> {
//                    phone_?.error = ""
//                }
//            }


//            when {
//                passwordLayout1?.editText?.text.toString() == "" -> {
//                    passwordLayout1?.error = getString(R.string.campo_requerido)
//                    return false
//                }
//                passwordLayout1?.editText?.text.toString().length < 8 -> {
//                    passwordLayout1?.error = getString(R.string.contraseña_8_caracteres)
//                    return false
//                }
//                passwordLayout1?.editText?.text.toString() != passwordLayout2?.editText?.text.toString() -> {
//                    passwordLayout2?.error = getString(R.string.password_debe_ser_similar)
//                }
//                else -> {
//                    passwordLayout1?.error = ""
//                }
//            }

            return true
        }

        private fun getUser(): EUser {

            val name        = if(holder_name?.editText?.text.toString() == profileViewModel.user.name || holder_name?.editText?.text.toString() == "" ) null else holder_name?.editText?.text.toString()
            val last_name   = if(last_name?.editText?.text.toString() == profileViewModel.user.last_name || last_name?.editText?.text.toString() == "" ) null else last_name?.editText?.text.toString()
            val email       = if(email?.editText?.text.toString() == profileViewModel.user.email || email?.editText?.text.toString() == "" ) null else email?.editText?.text.toString()
            val country     = if(country_?.editText?.text.toString() == profileViewModel.user.country || country_?.editText?.text.toString() == "") null else country_?.editText?.text.toString()
            val state       = if(state_?.editText?.text.toString() == profileViewModel.user.state || state_?.editText?.text.toString() == "") null else state_?.editText?.text.toString()
            val address     = if(address_?.editText?.text.toString() == profileViewModel.user.address || address_?.editText?.text.toString() == "") null else address_?.editText?.text.toString()
            val city        = if(city_?.editText?.text.toString() == profileViewModel.user.city || city_?.editText?.text.toString() == "" ) null else city_?.editText?.text.toString()
            val phone       = if(phone_?.editText?.text.toString() == profileViewModel.user.phone || phone_?.editText?.text.toString() == "" ) null else phone_?.editText?.text.toString()

            var sex: String?= if (first?.isChecked!!) "1" else if (second?.isChecked!!) "2" else null
            sex = if (sex == profileViewModel.user.sex ) null else sex

            return EUser(
                uuid_user= "0",
                name= name,
                last_name = last_name,
                email= email,
                country= country,
                state= state,
                city= city,
                address = address,
                phone= phone,
                sex= sex,
                typeOfUser= "wsl.com.tepeheapp",
                tokendevice = context?.getDeviceID()
            )

        }

    }


}
