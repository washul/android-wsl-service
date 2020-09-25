package com.wsl.login.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wsl.login.database.AppDataBase.Companion.DATABASE_VERSION

@Database(
    entities =
    [EUser::class, ECard::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDataBase: RoomDatabase() {

    abstract fun daoUser(): DAOUser
    abstract fun daoCard(): DAOCard

    companion object {

        internal const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "wsl-services"

        var INSTANCE: AppDataBase? = null
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