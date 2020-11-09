package com.wsl.login.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wsl.login.database.AppDataBase.Companion.DATABASE_VERSION
import com.wsl.login.database.dao.DAOCard
import com.wsl.login.database.dao.DAOPlan
import com.wsl.login.database.dao.DAOSubscription
import com.wsl.login.database.dao.DAOUser
import com.wsl.login.database.entities.ECard
import com.wsl.login.database.entities.EPlan
import com.wsl.login.database.entities.ESubscription
import com.wsl.login.database.entities.EUser

@Database(
    entities =
    [EUser::class, ECard::class, ESubscription::class, EPlan::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDataBase: RoomDatabase() {

    abstract fun daoUser(): DAOUser
    abstract fun daoCard(): DAOCard
    abstract fun daoSubscription(): DAOSubscription
    abstract fun daoPlan(): DAOPlan

    companion object {

        internal const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "wsl-services"

        private var INSTANCE: AppDataBase? = null
        fun getInstance( context: Context ): AppDataBase? {

            if ( INSTANCE == null ){

                synchronized(AppDataBase::class){

                    INSTANCE = Room.databaseBuilder( context.applicationContext, AppDataBase::class.java, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build()

                }

            }

            return INSTANCE

        }

    }
}