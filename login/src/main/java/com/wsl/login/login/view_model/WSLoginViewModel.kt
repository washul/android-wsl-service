package com.wsl.login.login.view_model

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.wsl.login.database.entities.EConfig
import com.wsl.login.database.entities.EUser
import com.wsl.login.retrofit.LoginResponse
import com.wsl.login.retrofit.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WSLoginViewModel @ViewModelInject constructor(
    private var repository: RepositoryLogin
    ) : ViewModel() {

    var isTrackingAppOut = false

    private var _configFile = MutableLiveData<EConfig?>()
    val configFile: LiveData<EConfig?> = _configFile
    fun setConfigFile(configFile: EConfig?) {
        if (configFile == null )return
        _configFile.postValue(configFile)
    }

    val projectIcon = Transformations
        .map(_configFile) {
            it?.project_icon
        }

    var userID: String = ""
        set(value) {
            field = value
            repository.prefs.userID = value
        }
        get(){
            if ( field == "" ){
                field = repository.prefs.userID
            }
            return field
        }
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
    private val _onUserSignInCorrectly = MutableLiveData<EUser?>()
    val onUserSignInCorrectly: LiveData<EUser?> = _onUserSignInCorrectly
    fun setUserSignInCorrectly(user: EUser?){ _onUserSignInCorrectly.postValue(user) }
    fun setOnUserSignInCorrectlyDone(){ _onUserSignInCorrectly.postValue(null) }

    /**
     * _requireRegisterUser ->
     * Require a register by a dialog, and request to the activity this dialog
     * */
    private val _requireRegisterUser = MutableLiveData<EUser?>()
    val requireRegisterUser: LiveData<EUser?> = _requireRegisterUser
    fun setUserToRegister(user: EUser?){ _requireRegisterUser.postValue(user) }
    fun setUserToRegisterDone(){ _requireRegisterUser.postValue(null) }


//    LOCAL METHODS
    fun localSignIn( function: (EUser?) -> Unit ) {
        viewModelScope.launch(Dispatchers.IO) {
            function(repository.localSignIn())
        }
    }

    fun saveUserOrUpdate(user: EUser) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveUserOrUpdate( user )
        }
    }

    fun getUserLiveData() = repository.getUserLiveData()

    fun getLocalUserAsync(function: (EUser?) -> Unit) = repository.getLocalUserAsync(function)

//    CLOUD METHODS
    fun login(
        user: EUser,
        function: (EUser?) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.login( user, function )
        }
    }

    fun loginAuto( function: (String?) -> Unit ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.loginAuto(function)
        }
    }

    fun getLogOut(function: (Boolean) -> Unit) = repository.logOut(function)

    fun register(user: EUser, function: (RegisterResponse?) -> Unit ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.registerUser( user, function )
        }
    }

    fun logOut(){
        repository.logOut{}
    }

}