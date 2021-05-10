package com.wsl.login.payments.viewmodel

import android.app.Application
import android.util.Log
import com.wsl.login.dagger.AppComponent
import com.wsl.login.dagger.DaggerApplication
import com.wsl.login.database.*
import com.wsl.login.database.dao.DAOCard
import com.wsl.login.database.dao.DAOPlan
import com.wsl.login.database.dao.DAOSubscription
import com.wsl.login.database.dao.DAOUser
import com.wsl.login.database.entities.*
import com.wsl.login.helpers.TAG
import com.wsl.login.retrofit.RetrofitServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
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
    private lateinit var daoSubscription: DAOSubscription
    private lateinit var daoPlan: DAOPlan

    companion object {

        private lateinit var instance: RepositoryPayments

        fun build( context: Application): RepositoryPayments {

            if ( !Companion::instance.isInitialized ){

                instance = RepositoryPayments().apply {

                    this.dataBase = AppDataBase.getInstance( context )!!
                    this.daoUser = this.dataBase.daoUser()
                    this.daoCard = this.dataBase.daoCard()
                    this.daoSubscription = this.dataBase.daoSubscription()
                    this.daoPlan = this.dataBase.daoPlan()

                    val appComponent: AppComponent = DaggerApplication().initDaggerComponent( context )
                    appComponent.inject(this)

                    this.service = retrofit.create(RetrofitServices::class.java)

                }

            }

            return instance

        }

    }

    fun generateSubscription(card_id: String, plan_id: String, function: (SubscriptionResponse?) -> Unit ){

        try{

            val rootObject= JSONObject()
            rootObject.put("token_id", card_id)
            rootObject.put("plan_id", plan_id)

            compositeDisposable.add( service.paySubscription( rootObject ).subscribeOn(Schedulers.io() )
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->

                    function( data )

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

    fun getPlanList( function: (PlanResponse? ) -> Unit ){

        try{

            compositeDisposable.add( service.getPlan().subscribeOn(Schedulers.io() )
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->

                    function( data )

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

    fun getSubscription( function: (SubscriptionResponse?) -> Unit ){

        try{
            compositeDisposable.add( service.getSubscription().subscribeOn(Schedulers.io() )
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->

                    function( data )

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

    /**Subscription Methods*/

    fun cancelSubscription( subscriptionID: String, function: (SubscriptionResponse?) -> Unit ){

        try{

            compositeDisposable.add( service.cancelSubscription( subscriptionID ).subscribeOn(Schedulers.io() )
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->

                    function( data )

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

    fun saveSubscription( subscription: ESubscription ){

//        doAsync {
            daoSubscription.saveSubscription(subscription)
//        }

    }

    fun getLocalSubscription( function: (List<ESubscription>?) -> Unit ){
//        doAsync {
            function( daoSubscription.getSubscriptions() )
//        }
    }

    /**User Methods*/
    fun getLocalUserLiveData() = daoUser.getUserLiveData()

    fun createOpenPayCustomer(function: (Boolean) -> Unit) {
        try{

            compositeDisposable.add( service.createOpenPayCustomer().subscribeOn(Schedulers.io() )
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ _ ->

                    function( true )

                },
                    {
                        it.printStackTrace()
                        function(false)
                    }
                )

            )

        }catch ( e: Exception){
            e.printStackTrace()
            function(false)
        }
    }

    /**Cards Methods*/

    fun downloadCards(function: (List<ECard>?) -> Unit) {
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

    fun registerCard( device_session_id: String, token_id: String, function: (List<ECard>?) -> Unit ) {
//        doAsync {

            try{

                val rootObject= JSONObject()
                rootObject.put("device_session_id",device_session_id)
                rootObject.put("token_id",token_id)

                compositeDisposable.add( service.registerCard( rootObject ).subscribeOn(Schedulers.io() )
                    .unsubscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ data ->

                        Log.e(TAG, data.toString())
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

//        }
    }

    fun getCardsLiveData() = daoCard.getCardsLiveData()

    fun getCards( function: (List<ECard>?) -> Unit ) {
//        doAsync {

            function( daoCard.getCards() )

//        }
    }

    fun saveCardList( list: List<ECard> ){
//        doAsync {

            daoCard.saveCardList( list )

//        }
    }

    fun removeCards( card_id: String, function: (CardsResponse?) -> Unit) {
        try{
            compositeDisposable.add( service.removeCard( card_id ).subscribeOn(Schedulers.io() )
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    function( data )
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

    /**Plan Methods*/

    fun savePlan ( plan: EPlan ) =
//        doAsync {
            daoPlan.save( plan )
//        }


}