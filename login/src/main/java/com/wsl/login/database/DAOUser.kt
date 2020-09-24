package com.wsl.login.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DAOUser {

    @Insert
    fun insertUser( user: EUser )

    @Query("SELECT uuid_user FROM User WHERE email == :email")
    fun isUserExist( email: String ): String

    @Query("SELECT * FROM User ")
    fun getUser(): EUser

    @Query("SELECT * FROM User ")
    fun getUserLiveData(): LiveData<EUser?>

    @Query("DELETE FROM User ")
    fun deleteUsers()

}