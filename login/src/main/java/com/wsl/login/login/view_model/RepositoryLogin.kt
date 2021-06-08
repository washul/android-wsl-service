package com.wsl.login.login.view_model

import android.util.Log
import com.wsl.login.retrofit.RetrofitServices
import com.wsl.login.helpers.WSPreferences
import com.wsl.login.database.AppDataBase
import com.wsl.login.database.entities.EUser
import com.wsl.login.helpers.isOnlineNet
import com.wsl.login.retrofit.LoginResponse
import com.wsl.login.retrofit.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class RepositoryLogin @Inject constructor(
    db: AppDataBase,
    var prefs: WSPreferences,
    private var service: RetrofitServices
    ) {

    private var daoUser = db.daoUser()
    val isNetworkAvailable = isOnlineNet()

//    MARK: LOCAL METHODS
    fun localSignIn(): EUser? {
            return daoUser.signIn()
    }

    fun saveUser( user: EUser){
            try {
                if (  user.uuid_user == daoUser.isUserExist( user.email!! ) ) {
                    daoUser.update(user)
                }else{
                    daoUser.insertUser( user )
                }
            }catch ( e: Exception ){
                e.printStackTrace()
            }
    }

    fun getUserLiveData() = daoUser.getUserLiveData()

    fun getLocalUserNoAsync() = daoUser.getUser()

    fun getLocalUserAsync( function: (EUser?) -> Unit ) {
//        doAsync {

            function(daoUser.getUser())

//        }
    }

    //    MARK: CLOUD METHODS
    suspend fun login(
        user: EUser,
        function: (LoginResponse?) -> Unit
    ) {
        val response = service.login( parameters = user )
        withContext(Dispatchers.IO){
            try {
                function(response.body())
            }catch ( e: Exception){
                e.printStackTrace()
                function(null)
            }
        }

    }

    suspend fun loginAuto(
        function: (LoginResponse?) -> Unit
    ){

        val response = service.loginAuto()
        withContext(Dispatchers.IO){
            try {
                if (response.isSuccessful)
                    Log.e("LOGIN RESPONSE ->  ", response.body().toString() )
                    function(response.body())
            }catch ( e: Exception){
                e.printStackTrace()
                function(null)
            }
        }
    }

    suspend fun registerUser(
        user: EUser,
        function: (RegisterResponse?) -> Unit
    ){
        val response = service.registerUser( user = user )
        withContext(Dispatchers.IO) {
            try {
                Log.e("REGISTER RESPONSE ->  ", response.body().toString() )
                function( response.body() )
            }catch ( e: Exception){
                e.printStackTrace()
                function(null)
            }
        }
    }

    suspend fun updateUser(
        user: EUser,
        function: (RegisterResponse?) -> Unit
    ){
        val response = service.updateUser( user = user )
        withContext(Dispatchers.IO) {
            try {
                Log.e("REGISTER RESPONSE ->  ", response.body().toString() )
                function( response.body() )
            }catch ( e: Exception){
                e.printStackTrace()
                function(null)
            }
        }
    }

    suspend fun getUser(
        function: (LoginResponse?) -> Unit
    ){

        val response = service.getUser()
        withContext(Dispatchers.IO) {
            try {
                Log.e("USER RESPONSE ->  ", response.blockingFirst().toString() )
                function(response.blockingFirst())
            }catch ( e: Exception){
                e.printStackTrace()
                function(null)
            }
        }
    }

    fun logOut( function: (Boolean) -> Unit) {
            daoUser.deleteUsers()
            prefs.tokenDevice = ""
            prefs.tokenUser = ""

            function(true)
    }

 }