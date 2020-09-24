package com.wsl.login.payments.viewmodel

import android.app.Application
import android.util.Log
import com.wsl.login.dagger.AppComponent
import com.wsl.login.dagger.DaggerApplication
import com.wsl.login.database.*
import com.wsl.login.helpers.TAG
import com.wsl.login.retrofit.RetrofitServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import org.json.JSONObject
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryPayments @Inject constructor() {

    @Inject
    lateinit var retrofit: Retrofit

    lateinit var service: RetrofitServices

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    private lateinit var dataBase: AppDataBase

    private lateinit var daoUser: DAOUser

    private lateinit var daoCard: DAOCard

    companion object {

        private lateinit var instance: RepositoryPayments

        fun build( context: Application): RepositoryPayments {

            if ( !Companion::instance.isInitialized ){

                instance = RepositoryPayments().apply {

                    this.dataBase = AppDataBase.getInstance( context )!!
                    this.daoUser = this.dataBase.daoUser()
                    this.daoCard = this.dataBase.daoCard()

                    val appComponent: AppComponent = DaggerApplication().initDaggerComponent( context )
                    appComponent.inject(this)

                    this.service = retrofit.create(RetrofitServices::class.java)

                }

            }

            return instance

        }

    }

    fun getLocalUserLiveData() = daoUser.getUserLiveData()

    fun downloadCards(function: (List<ECard>?) -> Unit) {
        doAsync {

            try{

                compositeDisposable.add( service.getCards().subscribeOn(Schedulers.io() )
                    .unsubscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ data ->

                        function( data.cards )

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

    fun registerCard( device_session_id: String, token_id: String ) {
        doAsync {

            try{

                val rootObject= JSONObject()
                rootObject.put("device_session_id",device_session_id)
                rootObject.put("token_id",token_id)

                compositeDisposable.add( service.registerCard( rootObject ).subscribeOn(Schedulers.io() )
                    .unsubscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ data ->

                        Log.e(TAG, data.toString())

                    },
                        {
                            it.printStackTrace()

                        }
                    )

                )

            }catch ( e: Exception){
                e.printStackTrace()

            }

        }
    }

    fun getCardsLiveData() = daoCard.getCardsLiveData()

    fun saveCardList( list: List<ECard> ){
        doAsync {

            daoCard.saveCardList( list )

        }
    }

}