package com.wsl.login.login.view_model

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.wsl.login.database.entities.EUser
import com.wsl.login.retrofit.LoginResponse
import com.wsl.login.retrofit.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WSLoginViewModel @ViewModelInject constructor(
    private var repository: RepositoryLogin
    ) : ViewModel() {

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

    var commonUser = EUser(uuid_user = "")

    private val _mutableUser = MutableLiveData<EUser>()
    val mutableUser = _mutableUser
    fun setUser(user: EUser) {
        _mutableUser.postValue(user)
    }


    val userRegister = MutableLiveData<EUser>()

    fun isNetworkAvailable()
            = repository.isNetworkAvailable
    var activityAction = -1

    /**
     * _onShowProgressDialog ->
     * This methods controlled the progressBar
     * */
    private val _onShowProgressDialog = MutableLiveData<Boolean>(false)
    val onShowProgressDialogLiveData: LiveData<Boolean>
        get() = this._onShowProgressDialog
    fun onShowProgressDialogDone()
            = _onShowProgressDialog.postValue(false)
    fun onShowProgressDialog()
            = _onShowProgressDialog.postValue(true)

    /**
     * _onShowErrorMessage ->
     * This methods controlled the snack bar
     * */
    private val _onShowErrorMessage = MutableLiveData<String?>()
    val onShowErrorMessage: LiveData<String?>
        get() = _onShowErrorMessage
    fun onShowErrorMessage(message: String){ _onShowErrorMessage.postValue(message) }
    fun onShowErrorMessageDone(){ _onShowErrorMessage.postValue(null) }

    /**
     * _onUserLoginCorrectly ->
     * Notify to the activity that the user is sign in
     * */
    private val _onUserSignInCorrectly = MutableLiveData<LoginResponse?>()
    val onUserSignInCorrectly: LiveData<LoginResponse?> = _onUserSignInCorrectly
    fun setUserSignInCorrectly(loginResponse: LoginResponse?){ _onUserSignInCorrectly.postValue(loginResponse) }
    fun setOnUserSignInCorrectlyDone(){ _onUserSignInCorrectly.postValue(null) }

    /**
     * _requireRegisterUser ->
     * Require a register by a dialog, and request to the activity this dialog
     * */
    private val _requireRegisterUser = MutableLiveData<EUser?>()
    val requireRegisterUser: LiveData<EUser?> = _requireRegisterUser
    fun setUserToRegister(user: EUser?){ _requireRegisterUser.postValue(user) }
    fun setUserToRegisterDone(){ _requireRegisterUser.postValue(null) }

    /**
     * _requireFirebaseAuth ->
     * Require a authenthication by firebase
     * */
    private val _requireFirebaseAuth = MutableLiveData<Task<AuthResult>?>()
    val requireFirebaseAuthLiveData: LiveData<Task<AuthResult>?> = _requireFirebaseAuth
    fun requireFirebaseAuth(user: Task<AuthResult>?){ _requireFirebaseAuth.postValue(user) }
    fun requireFirebaseAuthDone(){ _requireFirebaseAuth.postValue(null) }


//    LOCAL METHODS
    fun localSignIn( function: (EUser?) -> Unit ) {
        viewModelScope.launch(Dispatchers.IO) {
            function(repository.localSignIn())
        }
    }

    fun saveUser( user: EUser) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveUser( user )
        }
    }

    fun getUserLiveData() = repository.getUserLiveData()

    fun getLocalUserAsync(function: (EUser?) -> Unit) = repository.getLocalUserAsync(function)

//    CLOUD METHODS
    fun login(
        user: EUser,
        function: (LoginResponse?) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.login( user ) { response ->
                function(response)
            }
        }
    }

    fun loginAuto( function: (LoginResponse?) -> Unit ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.loginAuto{ response ->
                function(response)
            }
        }
    }

    fun getLogOut(function: (Boolean) -> Unit) = repository.logOut(function)

    fun register(user: EUser, function: (RegisterResponse?) -> Unit ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.registerUser( user, function )
        }
    }


}