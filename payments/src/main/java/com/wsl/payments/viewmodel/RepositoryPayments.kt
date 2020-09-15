package com.wsl.payments.viewmodel

import android.app.Application
import com.wsl.payments.dagger.AppComponent
import com.wsl.payments.dagger.DaggerApplication
import com.wsl.payments.model.AppDataBase
import com.wsl.payments.retrofit.RetrofitServices
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryPayments @Inject constructor() {

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var service: RetrofitServices

    private lateinit var dataBase: AppDataBase

    private val compositeDisposable = CompositeDisposable()

    companion object {

        private lateinit var instance: RepositoryPayments

        fun build( context: Application): RepositoryPayments {

            if ( !::instance.isInitialized ){

                instance = RepositoryPayments().apply {

                    this.dataBase = AppDataBase.getInstance( context )!!
                    val appComponent: AppComponent = DaggerApplication().initDaggerComponent( context )
                    appComponent.inject(this)

                }

            }

            return instance

        }

    }

}