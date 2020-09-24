package com.wsl.login.view_model

import android.app.Application
import android.util.Log
import com.wsl.login.retrofit.RetrofitServices
import com.wsl.login.dagger.AppComponent
import com.wsl.login.dagger.DaggerApplication
import com.wsl.login.helpers.Preferences
import com.wsl.utils.database.AppDataBase
import com.wsl.utils.database.DAOUser
import com.wsl.utils.database.EUser
import com.wsl.login.retrofit.LoginResponse
import com.wsl.login.retrofit.RegisterResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryLogin @Inject constructor() {

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var prefs: Preferences

    private lateinit var service: RetrofitServices

    @Inject
    lateinit var dataBase: AppDataBase

    private lateinit var daoUser: DAOUser

    private val compositeDisposable = CompositeDisposable()

    companion object {

        lateinit var instance: RepositoryLogin

        fun build( context: Application ): RepositoryLogin {

            if ( !::instance.isInitialized ){

                instance = RepositoryLogin().apply {

//                    this.dataBase = AppDataBase.getInstance( context )!!

                    val appComponent: AppComponent = DaggerApplication().initDaggerComponent( context )
                    appComponent.inject(this)
                    this.service = retrofit.create(RetrofitServices::class.java)
                    this.daoUser = this.dataBase.daoUser()

                }

            }

            return instance

        }

    }

//    MARK: LOCAL METHODS
    fun saveUser( user: EUser ){
        doAsync {
            try {
                if (  user.uuid != daoUser.isUserExist( user.email!! ) )
                    daoUser.insertUser( user )
            }catch ( e: Exception ){
                e.printStackTrace()
            }
        }
    }

    fun getUserLiveData() = daoUser.getUserLiveData()

    fun getLocalUser() = daoUser.getUser()

//    MARK: CLOUD METHODS
    fun login(user: EUser, function: (LoginResponse?) -> Unit ){

        try {

            //You need to use CompositeDisposables to manage the resources.
            compositeDisposable.add( service.login( parameters = user )
                .subscribeOn( Schedulers.io() )
                .unsubscribeOn( Schedulers.computation() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe({ responseBody ->

                    Log.e("LOGIN RESPONSE ->  ", responseBody.toString() )

                    function(responseBody)

                },
                    {
                        it.printStackTrace()
                        function(null)
                    }
                )

            )

        }catch ( e: Exception){
            e.printStackTrace()
            function(null)
        }

    }

    fun loginAuto( function: (LoginResponse?) -> Unit ){

        try {

            //You need to use CompositeDisposables to manage the resources.
            compositeDisposable.add( service.loginAuto()
                .subscribeOn( Schedulers.io() )
                .unsubscribeOn( Schedulers.computation() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe({ responseBody ->

                    Log.e("LOGIN RESPONSE ->  ", responseBody.toString() )


                    function(responseBody)

                },
                    {
                        it.printStackTrace()
                        function(null)
                    }
                )

            )

        }catch ( e: Exception){
            e.printStackTrace()
            function(null)
        }

    }

    fun register( user: EUser, function: (RegisterResponse?) -> Unit ){

        try {

            //You need to use CompositeDisposables to manage the resources.
            compositeDisposable.add( service.registerUser( user = user )
                .subscribeOn( Schedulers.io() )
                .unsubscribeOn( Schedulers.computation() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe({ registerResponse ->

                    Log.e("REGISTER RESPONSE ->  ", registerResponse.toString() )
                    function( registerResponse )

                },
                    {
                        it.printStackTrace()
                        function(null)
                    }
                )

            )

        }catch ( e: Exception){
            e.printStackTrace()
            function(null)
        }

    }

 }