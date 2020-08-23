package com.wsl.login.view_model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.wsl.login.ILoginService
import com.wsl.login.WSLoginActivity
import com.wsl.login.helpers.Preferences
import com.wsl.login.model.EUser
import com.wsl.login.retrofit.LoginResponse
import com.wsl.login.retrofit.RegisterResponse

class LoginViewModel: ViewModel() {

    lateinit var repository: RepositoryLogin
    lateinit var prefs: Preferences

    val user = MutableLiveData<EUser>()

    companion object {

        lateinit var instance: LoginViewModel

        fun build() : LoginViewModel {

            if ( !::instance.isInitialized ){

                instance = LoginViewModel()

            }

            return instance
        }
    }

//    LOCAL METHODS
    fun saveUser( user: EUser ) = repository.saveUser( user )


//    CLOUD METHODS
    fun login( user: EUser, function: (LoginResponse?) -> Unit ) = repository.login( user, function )

    fun register( user: EUser, function: (RegisterResponse?) -> Unit ) = repository.register( user, function )

}