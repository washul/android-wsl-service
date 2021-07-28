package com.wsl.login.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.wsl.login.database.entities.EConfig

@Dao
interface DAOConfig {

    @Insert
    fun insert(config: EConfig)

    @Query("SELECT * FROM config")
    fun get(): EConfig?

}