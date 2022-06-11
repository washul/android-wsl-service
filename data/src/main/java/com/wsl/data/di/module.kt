package com.wsl.data.di

import com.domain.domain.login.repository.RepositoryLogin
import com.wsl.data.db.AppDataBase
import com.wsl.data.login.repository.LocalDataSource
import com.wsl.data.login.repository.RemoteDataSource
import com.wsl.data.login.repository.RepositoryLoginImpl
import com.wsl.data.login.WSPreferences
import com.wsl.data.retrofit.RetrofitClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<RepositoryLogin> { RepositoryLoginImpl(get(), get() ) }
    single { AppDataBase.getInstance(androidContext()) }
    single { RetrofitClient.build(get()).retrofit }
    single { WSPreferences(androidContext()) }
    single { LocalDataSource(get(), get()) }
    single { RemoteDataSource(get()) }
    single { RepositoryLoginImpl(get(), get()) }
}