package com.wsl.login

import android.app.Application
import com.domain.domain.login.di.domainModule
import com.wsl.data.di.dataModule
import com.wsl.login.di.loginModule
import com.wsl.login.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LoginApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LoginApplication)
            modules(
                domainModule,
                dataModule,
                viewModelModule,
                loginModule
            )
        }
    }
}