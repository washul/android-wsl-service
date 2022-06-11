package com.wsl.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wsl.data.db.entities.EPlan
import com.wsl.data.db.entities.ESubscription

@Dao
interface DAOPlan {

    @Query("SELECT * FROM `plan`" )
    fun get(): List<EPlan>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save( plan: EPlan)

}