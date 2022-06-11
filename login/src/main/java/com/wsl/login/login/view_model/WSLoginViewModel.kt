package com.wsl.login.login.view_model

import androidx.lifecycle.*
import com.domain.domain.login.models.User
import com.utils.utils.*
import com.wsl.data.db.entities.EConfig
import com.wsl.login.login.CommonAuthenticationManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WSLoginViewModel constructor(
    private val authenticationManager: CommonAuthenticationManager
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
            setUserID()
        }
        get(){
            if ( field == "" ){
                field = authenticationManager.userID ?: ""
            }
            return field
        }
    var tokenUser: String = ""
        set(value) {
            field = value
            setTokenUser()
        }
        get(){
            if ( field == "" ){
                field = authenticationManager.tokenUser ?: ""
            }
            return field
        }
    var tokenDevice: String = ""
        set(value) {
            field = value
            setDeviceID()
        }
        get(){
            if ( field == "" ){
                field = authenticationManager.deviceID ?: ""
            }
            return field
        }

    init {
        authenticationManager.getSensitiveTokens()
    }

    private fun setUserID() =
        viewModelScope.launch(Dispatchers.IO) {
            authenticationManager.setUserID(userID)
                .onFailure {
                    //Handle error
                }
        }

    private fun setTokenUser() = viewModelScope.launch(Dispatchers.IO) {
        authenticationManager.setTokenUSer(tokenUser)
            .onFailure {
                //Handle error

            }
    }

    private fun setDeviceID() = viewModelScope.launch(Dispatchers.IO) {
        authenticationManager.setTokenDevice(tokenDevice)
            .onFailure {
                //Handle error
            }
    }


    var commonUser = User(uuid_user = "")

    private val _mutableUser = MutableLiveData<User>()
    val mutableUser = _mutableUser
    fun setUser(user: User) {
        _mutableUser.postValue(user)
    }


    val userRegister = MutableLiveData<User>()

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
    private val _onUserSignInCorrectly = MutableLiveData<Boolean>()
    val onUserSignInCorrectly: LiveData<Boolean> = _onUserSignInCorrectly
    fun setUserSignInCorrectly(isLogged: Boolean){ _onUserSignInCorrectly.postValue(isLogged) }
    fun setOnUserSignInCorrectlyDone(){ _onUserSignInCorrectly.postValue(false) }

    /**
     * _requireRegisterUser ->
     * Require a register by a dialog, and request to the activity this dialog
     * */
    private val _requireRegisterUser = MutableLiveData<User?>()
    val requireRegisterUser: LiveData<User?> = _requireRegisterUser
    fun setUserToRegister(user: User?){ _requireRegisterUser.postValue(user) }
    fun setUserToRegisterDone(){ _requireRegisterUser.postValue(null) }


//    LOCAL METHODS
    fun localSignIn( response: (Boolean) -> Unit ) {
        viewModelScope.launch(Dispatchers.IO) {
            authenticationManager.localSignIn()
                .onSuccess {
                    response(it)
                }
                .onFailure {
                    //send to handle error
                    response(false)
                }
        }
    }

    fun saveUserOrUpdate(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            authenticationManager.saveUserOrUpdate(user)
                .onFailure {
                    //Handle error
                }
        }
    }

//    CLOUD METHODS
    fun login(
        email: String,
        password: String,
        response: (Boolean) -> Unit
    )  = viewModelScope.launch(Dispatchers.IO) {
        authenticationManager.login(email, password)
            .onSuccess {
                response(it)
            }
            .onFailure {
                //Handle error
                //TODO: need to identify if this error is about network connection
                response(false)
                onShowErrorMessage(locateErrorMessage(it))
            }
    }


//    fun loginAuto(
//        function: (String?) -> Unit
//    ) = viewModelScope.launch(Dispatchers.IO) {
//
//    }


    fun getLogOut(
        function: (Boolean) -> Unit
    ) = viewModelScope.launch(Dispatchers.IO) {
        authenticationManager.logOut()
            .onSuccess(function)
            .onFailure {
                //Handle error
            }
    }

    fun register(
        user: User,
        function: (Boolean?) -> Unit
    ) = viewModelScope.launch(Dispatchers.IO) {
        authenticationManager.registerUser(user)
            .onSuccess(function)
            .onFailure {
                //Handle error
            }
    }


    fun logOut() = viewModelScope.launch(Dispatchers.IO) {authenticationManager.logOut()}

}