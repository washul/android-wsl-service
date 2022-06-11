package com.wsl.login.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.domain.domain.login.models.User
import com.wsl.login.R
import com.wsl.login.helpers.getDeviceID
import com.wsl.login.login.view_model.WSLoginViewModel
import com.wsl.login.databinding.FragmentRegisterBinding
import java.util.*

class RegisterFragment: Fragment() {

    lateinit var viewModel: WSLoginViewModel

    private lateinit var binding: FragmentRegisterBinding

    companion object {
        const val TAG = "RegisterFragment"
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle? ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        //            Tmp just for testing
        val userTemp = User(
            uuid_user = "",
            name="Alejandro",
            last_name = "Carrillo",
            email = "develop.wsl@gmail.com",
            password = "12345678",
            country = "Mexico",
            state = "Jalisco",
            city = "Zapopan",
            phone = "1234567890"
        )
        binding.user = userTemp

        setDefaultObservers()
        viewModel.onShowProgressDialogDone()
        return binding.root
    }

    private fun setDefaultObservers() {
        viewModel.userRegister.observe( viewLifecycleOwner, Observer { user ->
            viewModel.onShowProgressDialog()

            user.uuid_user = UUID.randomUUID().toString()
            user.tokendevice = context?.getDeviceID()
            viewModel.register( user ){ registerResponse ->

                if ( registerResponse == null ){
                    viewModel.onShowErrorMessage( getString(R.string.intentelo_mas_tarde) )
                    return@register
                }

//                if ( registerResponse.uuid_user == "0" ){
//                    viewModel.onShowErrorMessage( registerResponse.message )
//                    return@register
//                }
//
//                user.uuid_user = registerResponse.uuid_user
//                viewModel.tokenUser = registerResponse.token
                viewModel.tokenDevice = user.tokendevice ?: context?.getDeviceID() ?: ""

                viewModel.saveUserOrUpdate( user )

                viewModel.onShowProgressDialogDone()
                activity?.runOnUiThread {
                    findNavController().navigate(RegisterFragmentDirections.registerFragmentToLoginFragment())
                }
            }
        })

        initRegisterButton()
        viewModel.onShowProgressDialogDone()
    }

    private fun initRegisterButton(){

        binding.registrarse.setOnClickListener { _ ->

            binding.first.isChecked = true

            viewModel.onShowProgressDialog()

            //Validate text fields
            if ( !validateAllFields() )
                returnTransition

            viewModel.userRegister.postValue(binding.user)
        }

    }

    private fun validateAllFields(): Boolean {

        if ( binding.holderNameText.text.toString() == "" ) {
            binding.holderName.error = getString(R.string.campo_requerido)
            return false
        }else{
            binding.holderName.error = null
        }

        if ( binding.lastNameText.text.toString() == "" ) {
            binding.lastName.error = getString(R.string.campo_requerido)
            return false
        }else{
            binding.lastName.error = null
        }

        when {
            binding.editTextEmail.text.toString() == "" -> {
                binding.editTextEmail.error = getString(R.string.campo_requerido)
                return false
            }
            !binding.editTextEmail.text.toString().contains("@") -> {
                binding.email.error = getString(R.string.correo_no_valido)
                return false
            }
            else -> {
                binding.email.error = null
            }
        }

        if ( binding.countryText.text.toString() == "" ){
            binding.country.error = getString(R.string.campo_requerido)
            return false
        }else{
            binding.country.error = ""
        }
        if ( binding.stateText.text.toString() == "" ){
            binding.state.error = getString(R.string.campo_requerido)
            return false
        }else{
            binding.state.error = ""
        }
        if ( binding.cityText.text.toString() == "" ){
            binding.city.error = getString(R.string.campo_requerido)
            return false
        }else{
            binding.city.error = ""
        }

        when {
            binding.phoneText.text.toString() == "" -> {
                binding.phone.error = getString(R.string.campo_requerido)
                return false
            }
            binding.phoneText.text.toString().length < 8 -> {
                binding.phone.error = getString(R.string.telefono_no_valido)
                return false
            }
            else -> {
                binding.phone.error = ""
            }
        }


        when {
            binding.editTextPasswrdod1.text.toString() == "" -> {
                binding.passwordLayout1.error = getString(R.string.campo_requerido)
                return false
            }
            binding.editTextPasswrdod1.text.toString().length < 8 -> {
                binding.passwordLayout1.error = getString(R.string.contraseña_8_caracteres)
                return false
            }
            binding.editTextPasswrdod1.text.toString() != binding.editTextPasswrdod2.text.toString() -> {
                binding.passwordLayout2.error = getString(R.string.password_debe_ser_similar)
            }
            else -> {
                binding.passwordLayout2.error = ""
            }
        }

        return true
    }

}
