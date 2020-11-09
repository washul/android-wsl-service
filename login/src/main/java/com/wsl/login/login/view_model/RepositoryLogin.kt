package com.wsl.login.login.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.wsl.login.retrofit.RetrofitServices
import com.wsl.login.dagger.AppComponent
import com.wsl.login.dagger.DaggerApplication
import com.wsl.login.helpers.Preferences
import com.wsl.login.database.AppDataBase
import com.wsl.login.database.dao.DAOUser
import com.wsl.login.database.entities.EUser
import com.wsl.login.retrofit.LoginResponse
import com.wsl.login.retrofit.RegisterResponse
import com.wsl.login.helpers.registerNetworkCallback
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

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    private lateinit var service: RetrofitServices

    lateinit var dataBase: AppDataBase

    private lateinit var daoUser: DAOUser

    val isNetworkAvailable = MutableLiveData<Boolean>()

    companion object {

        lateinit var instance: RepositoryLogin

        fun build( context: Application ): RepositoryLogin {

            if ( !Companion::instance.isInitialized ){

                instance = RepositoryLogin().apply {

                    this.dataBase = AppDataBase.getInstance( context )!!
                    this.daoUser = this.dataBase.daoUser()

                    val appComponent: AppComponent = DaggerApplication().initDaggerComponent( context )
                    appComponent.inject(this)

                    this.service = retrofit.create(RetrofitServices::class.java)

                    context.registerNetworkCallback( isNetworkAvailable )

                }

            }

            return instance

        }

    }

//    MARK: LOCAL METHODS
    fun localSignIn( function: (EUser?) -> Unit ){

        doAsync {

            function(daoUser.signIn())

        }

    }

    fun saveUser( user: EUser){
        doAsync {
            try {
                if (  user.uuid_user == daoUser.isUserExist( user.email!! ) ) {
                    daoUser.update(user)
                }else{
                    daoUser.insertUser( user )
                }
            }catch ( e: Exception ){
                e.printStackTrace()
            }
        }
    }

    fun getUserLiveData() = daoUser.getUserLiveData()

    fun getLocalUserNoAsync() = daoUser.getUser()

    fun getLocalUserAsync( function: (EUser?) -> Unit ) {
        doAsync {

            function(daoUser.getUser())

        }
    }

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

    fun updateUser(user: EUser, function: (RegisterResponse?) -> Unit ){

        try {

            //You need to use CompositeDisposables to manage the resources.
            compositeDisposable.add( service.updateUser( user = user )
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

    fun getUser( function: (LoginResponse?) -> Unit ){

        try {

            //You need to use CompositeDisposables to manage the resources.
            compositeDisposable.add( service.getUser()
                .subscribeOn( Schedulers.io() )
                .unsubscribeOn( Schedulers.computation() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe({ responseBody ->

                    Log.e("USER RESPONSE ->  ", responseBody.toString() )

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

    fun logOut( function: (Boolean) -> Unit) {
        doAsync {
            daoUser.deleteUsers()
            prefs.tokenDevice = ""
            prefs.tokenUser = ""

            function(true)
        }
    }

 }