package com.wsl.login.view_model

import android.util.Log
import com.wsl.login.model.DAOUser
import com.wsl.login.model.EUser
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import wsl.com.tepeheapp.Utils.retrofit.RetrofitClient
import wsl.com.tepeheapp.Utils.retrofit.RetrofitServices
import java.lang.Exception
import kotlin.collections.ArrayList

class RepositoryLogin {

    private val retrofit = RetrofitClient.instance
    private val service = retrofit.create( RetrofitServices::class.java )
    private val compositeDisposable = CompositeDisposable()

    private lateinit var daoUser: DAOUser

    private val kindsOfUsers = ArrayList<String>()

//    MARK: CLOUD

    fun login(user: EUser, function: (EUser?) -> Unit ){

        try {

            //You need to use CompositeDisposables to manage the resources.
            compositeDisposable.add( service.login( user = user )
                .subscribeOn( Schedulers.io() )
                .unsubscribeOn( Schedulers.computation() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe({ list ->

                    Log.e("LOGIN RESPONSE ->  ", list.toString() )
//                    function( EUser("12345", "Covid-19", "covid@19.com", "Mexico", "Jalisco", "Guadalajara", "1234567890", "n/a", "Director") )

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

    fun register( user: EUser, function: (Boolean) -> Unit ){

        try {
//            val user = EUser(
//                uuid= UUID.randomUUID().toString(),
//                customer_id=null,
//                name="Edgar",
//                last_name="Carrillo",
//                username="",
//                email="develop.wsl2@gmail.com",
//                country="Mexico",
//                state="Jalisco",
//                city="Zapopan",
//                postal_code="45059",
//                country_code="MX",
//                phone="1234567890",
//                address=null,
//                latitude=null,
//                longitude=null,
//                sex=null,
//                typeOfUser="wsl.com.tepeheapp",
//                password="12345"
//            )


            //You need to use CompositeDisposables to manage the resources.
            compositeDisposable.add( service.registerUser( user = user )
                .subscribeOn( Schedulers.io() )
                .unsubscribeOn( Schedulers.computation() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe({ list ->

                    Log.e("REGISTER RESPONSE ->  ", list.toString() )
                    function( true )

                },
                    {
                        it.printStackTrace()
//                        function(false)//this is real
                        function(true)//This is fake response to true
                    }
                )

            )

        }catch ( e: Exception){
            e.printStackTrace()
            function(false)
        }

    }


 }