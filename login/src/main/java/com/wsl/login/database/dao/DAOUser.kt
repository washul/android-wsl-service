package com.wsl.login.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.wsl.login.database.entities.EUser

@Dao
interface DAOUser {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser( user: EUser)

    @Update
    fun update( user: EUser)

    @Query("SELECT * FROM User ")
    fun signIn(): EUser?

    @Query("SELECT uuid_user FROM User WHERE email == :email")
    fun isUserExist( email: String ): String?

    @Query("SELECT * FROM User ")
    fun getUser(): EUser

    @Query("SELECT * FROM User ")
    fun getUserLiveData(): LiveData<EUser?>

    @Query("DELETE FROM User ")
    fun deleteUsers()

}