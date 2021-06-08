package com.wsl.login.profile.view_model

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wsl.login.database.entities.*
import com.wsl.login.login.view_model.RepositoryLogin
import com.wsl.login.payments.viewmodel.RepositoryPayments
import com.wsl.login.retrofit.LoginResponse
import com.wsl.login.retrofit.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WSProfileViewModel @ViewModelInject constructor(
    private val repositoryLogin: RepositoryLogin,
    private val repositoryPayments: RepositoryPayments
) : ViewModel() {

    var packageVersion: String? = null

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

    var subscriptions: List<ESubscription> = emptyList()

    var currentSubscription: ESubscription? = null
    var subscriptionMutable = MutableLiveData<ESubscription?>()

    var currentPlan: EPlan? = null
    var planMutable = MutableLiveData<EPlan?>()

    var cardsMutable = MutableLiveData<List<ECard>>()

    lateinit var user: EUser
    val userMutable = MutableLiveData<EUser>()
    val userUpdate = MutableLiveData<EUser>()

    var tokenUser: String = ""
        set(value) {
            field = value

            repositoryLogin.prefs.tokenUser = value
        }
        get(){

            if ( field == "" ){
                field = repositoryLogin.prefs.tokenUser
            }

            return field
        }


    /**User Methods*/
    fun saveUser( user: EUser) {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryLogin.saveUser( user )
        }
    }

    fun getUserLiveData() = repositoryLogin.getUserLiveData()

    fun getUserLocalAsync(function: (EUser?) -> Unit ) = repositoryLogin.getLocalUserAsync( function )

    fun updateUser(
        user: EUser,
        function: (RegisterResponse?) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryLogin.updateUser( user, function )
        }
    }

    fun getUserCloud(
        function: (LoginResponse?) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryLogin.getUser(function)
        }
    }

    fun getLogOut(function: (Boolean) -> Unit) = repositoryLogin.logOut(function)



//    OPENPAY

    /**Subscription Methods*/

    fun saveSubscription(
        subscription: ESubscription
    ) = viewModelScope.launch(Dispatchers.IO){
        repositoryPayments.saveSubscription( subscription )
    }

    fun getSubscription(
        function: (SubscriptionResponse?) -> Unit
    ) = viewModelScope.launch(Dispatchers.IO){
        repositoryPayments.getSubscription( function )
    }

    fun getLocalSubscriptions(
        function: (List<ESubscription>?) -> Unit
    ) = viewModelScope.launch(Dispatchers.IO){
        repositoryPayments.getLocalSubscription( function )
    }

    fun cancelSubscription(
        subscriptionID: String,
        function: (SubscriptionResponse?) -> Unit
    ) = viewModelScope.launch(Dispatchers.IO){
        repositoryPayments.cancelSubscription( subscriptionID, function )
    }


    /**Cards Methods*/

    fun getCardsLiveData()
            = repositoryPayments.getCardsLiveData()

    fun saveCards(
        list: List<ECard>
    ) = viewModelScope.launch(Dispatchers.IO){
        repositoryPayments.saveCardList( list )
    }

    fun downloadCards(
        function: (List<ECard>?) -> Unit
    ) = viewModelScope.launch(Dispatchers.IO){
        repositoryPayments.downloadCards( function )
    }


    /**Plan Methods*/

    fun savePlan (
        plan: EPlan
    ) = viewModelScope.launch(Dispatchers.IO){
        repositoryPayments.savePlan( plan )
    }

}