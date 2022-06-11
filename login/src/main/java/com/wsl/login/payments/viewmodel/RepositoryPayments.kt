package com.wsl.login.payments.viewmodel

//import android.util.Log
//import com.wsl.data.db.*
//import com.wsl.data.db.entities.*
//import com.wsl.login.helpers.TAG
//import com.wsl.data.retrofit.RetrofitServices
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//import org.json.JSONObject
//
//class RepositoryPayments(
//    db: AppDataBase,
//    private var service: RetrofitServices
//    )
//{
//
//
////    private var daoUser = db.daoUser()
////    private var daoCard = db.daoCard()
////    private var daoSubscription = db.daoSubscription()
////    private var daoPlan = db.daoPlan()
//
//    suspend fun generateSubscription(
//        card_id: String,
//        plan_id: String,
//        function: (SubscriptionResponse?) -> Unit
//    ){
//        val rootObject= JSONObject()
//        rootObject.put("token_id", card_id)
//        rootObject.put("plan_id", plan_id)
//
//        val service = service.paySubscription( rootObject )
//        withContext(Dispatchers.IO){
//            try{
//                function( service.blockingFirst() )
//            }catch ( e: Exception){
//                e.printStackTrace()
//                function(null)
//            }
//        }
//    }
//
//    suspend fun getPlanList(
//        function: (PlanResponse? ) -> Unit
//    ) {
//        val service = service.getPlan()
//        withContext(Dispatchers.IO) {
//            try{
//                function( service.blockingFirst() )
//            }catch ( e: Exception){
//                e.printStackTrace()
//                function(null)
//            }
//        }
//    }
//
//    suspend fun getSubscription(
//        function: (SubscriptionResponse?) -> Unit
//    ) {
//        val service = service.getSubscription()
//        withContext(Dispatchers.IO){
//            try{
//                function( service.blockingFirst() )
//            }catch ( e: Exception){
//                e.printStackTrace()
//                function(null)
//            }
//        }
//    }
//
//    /**Subscription Methods*/
//
//    suspend fun cancelSubscription(
//        subscriptionID: String,
//        function: (SubscriptionResponse?) -> Unit
//    ) {
//        val service = service.cancelSubscription(subscriptionID)
//        withContext(Dispatchers.IO){
//            try{
//                function( service.blockingFirst() )
//            }catch ( e: Exception){
//                e.printStackTrace()
//                function(null)
//            }
//        }
//    }
//
//    suspend fun saveSubscription( subscription: ESubscription )
//        = withContext(Dispatchers.IO){
////            daoSubscription.saveSubscription(subscription)
//        }
//
//
//    suspend fun getLocalSubscription( function: (List<ESubscription>?) -> Unit )
//        = withContext(Dispatchers.IO){
////            function( daoSubscription.getSubscriptions() )
//        }
//
////    /**User Methods*/
////    fun getLocalUserLiveData()
////        = daoUser.getUserLiveData()
//
//    suspend fun createOpenPayCustomer(
//        function: (Boolean) -> Unit
//    ) {
//        val service = service.createOpenPayCustomer()
//        withContext(Dispatchers.IO){
//            try{
//                if (service.body() != null)
//                    function( true )
//            }catch ( e: Exception){
//                e.printStackTrace()
//                function(false)
//            }
//        }
//    }
//
//    /**Cards Methods*/
//
//    suspend fun downloadCards(
//        function: (List<ECard>?) -> Unit
//    ) {
//        val service = service.getCards()
//        withContext(Dispatchers.IO){
//            try{
//                function( service.blockingFirst().cards )
//            }catch ( e: Exception){
//                e.printStackTrace()
//                function(null)
//            }
//        }
//    }
//
//    suspend fun registerCard(
//        device_session_id: String,
//        token_id: String,
//        function: (List<ECard>?) -> Unit
//    ) {
//        val rootObject= JSONObject()
//        rootObject.put("device_session_id",device_session_id)
//        rootObject.put("token_id",token_id)
//
//        val service = service.registerCard(rootObject)
//        withContext(Dispatchers.IO) {
//            try{
//                Log.e(TAG, service.blockingFirst().toString())
//                function( service.blockingFirst().cards )
//            }catch ( e: Exception){
//                e.printStackTrace()
//                function(null)
//            }
//        }
//    }
//
////    fun getCardsLiveData()
////        = daoCard.getCardsLiveData()
//
////    suspend fun getCards(
////        function: (List<ECard>?) -> Unit
////    ) = withContext(Dispatchers.IO){
////            function( daoCard.getCards() )
////        }
//
//
//    suspend fun saveCardList(
//        list: List<ECard>
//    ) = withContext(Dispatchers.IO ) {
//            daoCard.saveCardList( list )
//    }
//
//    suspend fun removeCards(
//        card_id: String,
//        function: (CardsResponse?) -> Unit
//    ) {
//        val service = service.removeCard(card_id)
//        withContext(Dispatchers.IO){
//            try{
//                function( service.blockingFirst() )
//            }catch ( e: Exception){
//                e.printStackTrace()
//                function(null)
//            }
//        }
//    }
//
//    /**Plan Methods*/
//
//    suspend fun savePlan(
//        plan: EPlan
//    ) = withContext(Dispatchers.IO){
//        daoPlan.save( plan )
//    }
//}