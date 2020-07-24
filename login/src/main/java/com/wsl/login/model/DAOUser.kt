package com.wsl.login.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DAOUser {

    @Insert
    fun insertUser( user: EUser )

    @Query("SELECT * FROM User ")
    fun getUser(): EUser

    @Delete
    fun deleteUser( user: EUser )

}