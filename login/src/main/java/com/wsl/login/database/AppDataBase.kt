package com.wsl.login.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wsl.login.database.AppDataBase.Companion.DATABASE_VERSION
import com.wsl.login.database.dao.*
import com.wsl.login.database.entities.*

@Database(
    entities =
    [
        EUser::class,
        ECard::class,
        ESubscription::class,
        EPlan::class,
        EConfig::class
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDataBase: RoomDatabase() {

    abstract fun daoUser(): DAOUser
    abstract fun daoCard(): DAOCard
    abstract fun daoSubscription(): DAOSubscription
    abstract fun daoPlan(): DAOPlan
    abstract fun daoConfig(): DAOConfig

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