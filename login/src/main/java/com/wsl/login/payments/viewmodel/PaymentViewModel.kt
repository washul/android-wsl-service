package com.wsl.login.payments.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wsl.login.database.entities.*
import javax.inject.Inject

class PaymentViewModel @Inject constructor(): ViewModel() {

    @Inject
    lateinit var repository: RepositoryPayments

    var cards = ArrayList<ECard>()
    set(value) {
        val aux = ArrayList<ECard>()
        for( card in value ){
            for ( localCard in cards ){
                if ( card.id != localCard.id ){
                    aux.add( card )
                }
            }
        }

        if (aux.isNotEmpty()){
            value.addAll( aux )
            field = value
        }

    }
    var cardsMutable = MutableLiveData<List<ECard>>()


    var currentPlan: EPlan? = null

    var planList: List<EPlan> = emptyList()
    set(value) {
        field = value
        planListMutable.value = value
    }

    var planListMutable = MutableLiveData<List<EPlan>>()

    var activityActions = ArrayList<Int>()

    /**User methods*/

    fun getUserLiveData() = repository.getLocalUserLiveData()

    /**Cards*/

    fun saveCards(list: List<ECard>) {
        repository.saveCardList( list )
        cardsMutable.value = list
    }

    fun registerCard( device_session_id: String, token_id: String, function: (List<ECard>?) -> Unit )
            = repository.registerCard( device_session_id, token_id, function )

    fun downloadCards(function: (List<ECard>?) -> Unit )
            = repository.downloadCards( function )

    fun createOpenPayCustomer( function: (Boolean) -> Unit )
            = repository.createOpenPayCustomer(function)

    fun removeCard( card_id: String, function: (CardsResponse?) -> Unit )
            = repository.removeCards( card_id, function )


    /**Plans*/

    fun getPlanList( function: (PlanResponse?) -> Unit )
            = repository.getPlanList( function )


    /**Subscriptions*/

    fun generateSubscription(card_id: String, plan_id: String, function: (SubscriptionResponse?) -> Unit )
            = repository.generateSubscription( card_id, plan_id, function )

    fun getSubscription(function: (SubscriptionResponse?) -> Unit )
            = repository.getSubscription( function )

    fun cancelPayment( subscriptionID: String, function: (SubscriptionResponse?) -> Unit )
            = repository.cancelSubscription( subscriptionID, function )

    fun saveSubscription( subscription: ESubscription )
            = repository.saveSubscription( subscription )

}