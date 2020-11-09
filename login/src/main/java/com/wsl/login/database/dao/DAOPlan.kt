package com.wsl.login.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wsl.login.database.entities.EPlan
import com.wsl.login.database.entities.ESubscription

@Dao
interface DAOPlan {

    @Query("SELECT * FROM `plan`" )
    fun get(): List<EPlan>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save( plan: EPlan)

}