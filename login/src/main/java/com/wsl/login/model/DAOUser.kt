package com.wsl.login.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DAOUser {

    @Insert
    fun insertUser( user: EUser )

    @Query("SELECT uuid FROM User WHERE email == :email")
    fun isUserExist( email: String ): String

    @Query("SELECT * FROM User ")
    fun getUser(): EUser

    @Delete
    fun deleteUser( user: EUser )

}