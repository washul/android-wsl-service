package com.wsl.login.payments.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wsl.login.database.entities.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class WSPaymentViewModel @ViewModelInject constructor(
    var repository: RepositoryPayments
) : ViewModel() {

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
        planListMutable.postValue(value)
    }

    var planListMutable = MutableLiveData<List<EPlan>>()

    var activityActions = ArrayList<Int>()

    /**User methods*/

    fun getUserLiveData() = repository.getLocalUserLiveData()

    /**Cards*/

    fun saveCards(
        list: List<ECard>
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveCardList( list )
            cardsMutable.postValue(list)
        }
    }

    fun registerCard(
        device_session_id: String,
        token_id: String,
        function: (List<ECard>?) -> Unit
    ) = viewModelScope.launch(Dispatchers.IO) {
        repository.registerCard( device_session_id, token_id, function )
    }


    fun downloadCards(
        function: (List<ECard>?) -> Unit
    ) = viewModelScope.launch(Dispatchers.IO) {
        repository.downloadCards( function )
    }

    fun createOpenPayCustomer(
        function: (Boolean) -> Unit
    ) = viewModelScope.launch(Dispatchers.IO) {
        repository.createOpenPayCustomer(function)
    }

    fun removeCard(
        card_id: String,
        function: (CardsResponse?) -> Unit
    ) = viewModelScope.launch(Dispatchers.IO) {
        repository.removeCards( card_id, function )
    }


    /**Plans*/

    fun getPlanList(
        function: (PlanResponse?) -> Unit
    ) = viewModelScope.launch(Dispatchers.IO) {
        repository.getPlanList( function )
    }


    /**Subscriptions*/

    fun generateSubscription(
        card_id: String,
        plan_id: String,
        function: (SubscriptionResponse?) -> Unit
    ) = viewModelScope.launch(Dispatchers.IO) {
        repository.generateSubscription( card_id, plan_id, function )
    }

    fun getSubscription(
        function: (SubscriptionResponse?) -> Unit
    ) = viewModelScope.launch(Dispatchers.IO) {
        repository.getSubscription( function )
    }

    fun cancelPayment(
        subscriptionID: String,
        function: (SubscriptionResponse?) -> Unit
    ) = viewModelScope.launch(Dispatchers.IO) {
        repository.cancelSubscription( subscriptionID, function )
    }

    fun saveSubscription(
        subscription: ESubscription
    ) = viewModelScope.launch(Dispatchers.IO) {
        repository.saveSubscription( subscription )
    }
}