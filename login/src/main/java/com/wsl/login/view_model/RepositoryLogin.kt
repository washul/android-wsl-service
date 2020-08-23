package com.wsl.login.view_model

import android.content.Context
import android.util.Log
import com.wsl.login.model.AppDataBase
import com.wsl.login.model.DAOUser
import com.wsl.login.model.EUser
import com.wsl.login.retrofit.LoginResponse
import com.wsl.login.retrofit.RegisterResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.jetbrains.anko.doAsync
import org.json.JSONObject
import wsl.com.tepeheapp.Utils.retrofit.RetrofitClient
import wsl.com.tepeheapp.Utils.retrofit.RetrofitServices


class RepositoryLogin {

    private val retrofit = RetrofitClient.instance
    private val service = retrofit.create( RetrofitServices::class.java )
    private val compositeDisposable = CompositeDisposable()

    private lateinit var dataBase: AppDataBase
    private lateinit var daoUser: DAOUser

    companion object {

        private lateinit var instance: RepositoryLogin

        fun build( context: Context ): RepositoryLogin {

            if ( !::instance.isInitialized ){

                instance = RepositoryLogin().apply {
                    this.dataBase = AppDataBase.getInstance( context )!!
                    this.daoUser = dataBase.daoUser()
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

//    MARK: CLOUD METHODS
    fun login(user: EUser, function: (LoginResponse?) -> Unit ){

        try {

            val paramObject = JSONObject()
            paramObject.put("email", user.email)
            paramObject.put("password", user.password)

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
//TODO: revisar la peticion al ackend
                },
                    {
                        it.printStackTrace()
//                        function(false)//this is real
                        function(null)//This is fake response to true
                    }
                )

            )

        }catch ( e: Exception){
            e.printStackTrace()
            function(null)
        }

    }

 }