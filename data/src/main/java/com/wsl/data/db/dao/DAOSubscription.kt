package com.wsl.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wsl.data.db.entities.ESubscription

@Dao
interface DAOSubscription {

    @Query("SELECT * FROM subscription" )
    fun getSubscriptions(): List<ESubscription>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveSubscription( subscription: ESubscription)

}