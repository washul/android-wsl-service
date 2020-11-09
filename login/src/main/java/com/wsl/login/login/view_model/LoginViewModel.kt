package com.wsl.login.login.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wsl.login.database.entities.EUser
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
    var tokenDevice: String = ""
        set(value) {
            field = value

            repository.prefs.tokenDevice = value
        }
        get(){

            if ( field == "" ){
                field = repository.prefs.tokenDevice
            }

            return field
        }

    val userRegister = MutableLiveData<EUser>()

    fun isNetworkObservable() = repository.isNetworkAvailable
    var activityAction = -1

//    LOCAL METHODS
    fun localSignIn( function: (EUser?) -> Unit ) = repository.localSignIn( function )

    fun saveUser( user: EUser) = repository.saveUser( user )

    fun getUserLiveData() = repository.getUserLiveData()

    fun getLocalUserAsync(function: (EUser?) -> Unit) = repository.getLocalUserAsync(function)

//    CLOUD METHODS
    fun login(user: EUser, function: (LoginResponse?) -> Unit ) = repository.login( user, function )

    fun loginAuto( function: (LoginResponse?) -> Unit ) = repository.loginAuto( function )

    fun getLogOut(function: (Boolean) -> Unit) = repository.logOut(function)

    fun register(user: EUser, function: (RegisterResponse?) -> Unit ) = repository.updateUser( user, function )

}