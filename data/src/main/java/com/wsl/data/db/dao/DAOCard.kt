package com.wsl.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wsl.data.db.entities.ECard

@Dao
interface DAOCard {

    @Query("SELECT * FROM card" )
    fun getCardsLiveData(): LiveData<List<ECard>>

    @Query("SELECT * FROM card" )
    fun getCards(): List<ECard>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCardList( list: List<ECard>)

}