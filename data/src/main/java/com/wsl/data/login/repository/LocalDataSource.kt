package com.wsl.data.login.repository

import com.utils.utils.Failure
import com.utils.utils.Result
import com.wsl.data.db.AppDataBase
import com.wsl.data.db.entities.EUser
import com.wsl.data.login.WSPreferences

class LocalDataSource(
    private val preferences: WSPreferences,
    private val dataBase: AppDataBase
) {

    private val daoUser = dataBase.daoUser()

    var tokenUser: String
        get() = preferences.tokenUser
        set(value) { preferences.tokenUser = value }

    var tokenDevice: String
        get() = preferences.tokenDevice
        set(value) { preferences.tokenDevice = value }

    var uuidUser: String
        get() = preferences.userID
        set(value) { preferences.userID = value }

    fun localSignIn(): String {
        return preferences.tokenUser
    }

    suspend fun saveUserOrUpdate(user: EUser): Result<Failure, Boolean> {
        return try {
            val localUidUSer: String? = daoUser.isUserExist( user.email!! )
            if (localUidUSer != null && user.uuid_user == localUidUSer ) {
                daoUser.update(user)
                Result.Success(true)
            }else{
                daoUser.insertUser( user )
                Result.Success(true)
            }
        }catch ( e: Exception ){
            e.printStackTrace()
            Result.Failure(Failure.ServerError(e))
        }
    }

    fun logOut(): Result<Failure, Boolean> {
        return try {
            daoUser.deleteUsers()
            tokenUser = ""
            uuidUser = ""

            Result.Success(true)
        } catch (e: Throwable) {
            e.printStackTrace()
            Result.Failure(Failure.ServerError(e))
        }
    }

}