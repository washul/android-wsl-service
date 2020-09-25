package com.wsl.login.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAOCard {

    @Query("SELECT * FROM card" )
    fun getCardsLiveData(): LiveData<List<ECard>>

    @Insert
    fun saveCardList( list: List<ECard>)

}