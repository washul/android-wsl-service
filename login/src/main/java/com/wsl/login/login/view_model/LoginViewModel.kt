package com.wsl.login.login.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wsl.login.database.EUser
import com.wsl.login.retrofit.LoginResponse
import com.wsl.login.retrofit.RegisterResponse
import javax.inject.Inject

class LoginViewModel @Inject constructor(): ViewModel() {

    @Inject
    lateinit var repository: RepositoryLogin

    var tokenUser: String = ""
        set(value) {
            field = value

            repository.prefs.tokenUser = value
        }
        get(){

            if ( field == "" ){
                field = repository.prefs.tokenUser
            }

            return field
        }

    val userRegister = MutableLiveData<EUser>()


//    LOCAL METHODS
    fun saveUser( user: EUser ) = repository.saveUser( user )

    fun getUserLiveData() = repository.getUserLiveData()

//    CLOUD METHODS
    fun login( user: EUser, function: (LoginResponse?) -> Unit ) = repository.login( user, function )

    fun loginAuto( function: (LoginResponse?) -> Unit ) = repository.loginAuto( function )

    fun register( user: EUser, function: (RegisterResponse?) -> Unit ) = repository.register( user, function )

}