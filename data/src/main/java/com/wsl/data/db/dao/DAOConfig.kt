package com.wsl.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.wsl.data.db.entities.EConfig

@Dao
interface DAOConfig {

    @Insert
    fun insert(config: EConfig)

    @Query("SELECT * FROM config")
    fun get(): EConfig?

}