package com.wsl.data.db.dao

import androidx.room.*
import com.wsl.data.db.entities.EUser

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

    @Query("DELETE FROM User ")
    fun deleteUsers()

}