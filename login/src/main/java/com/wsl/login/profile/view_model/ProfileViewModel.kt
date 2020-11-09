package com.wsl.login.profile.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.facebook.internal.Mutable
import com.wsl.login.database.entities.*
import com.wsl.login.login.view_model.RepositoryLogin
import com.wsl.login.payments.viewmodel.RepositoryPayments
import com.wsl.login.retrofit.LoginResponse
import com.wsl.login.retrofit.RegisterResponse
import javax.inject.Inject

class ProfileViewModel @Inject constructor(): ViewModel() {

    @Inject lateinit var repositoryLogin: RepositoryLogin
    @Inject lateinit var repositoryPayments: RepositoryPayments

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
    fun saveUser( user: EUser) = repositoryLogin.saveUser( user )

    fun getUserLiveData() = repositoryLogin.getUserLiveData()

    fun getUserLocalAsync(function: (EUser?) -> Unit ) = repositoryLogin.getLocalUserAsync( function )

    fun updateUser(user: EUser, function: (RegisterResponse?) -> Unit ) = repositoryLogin.updateUser( user, function )

    fun getUserCloud(function: (LoginResponse?) -> Unit ) = repositoryLogin.getUser( function )

    fun getLogOut(function: (Boolean) -> Unit) = repositoryLogin.logOut(function)



//    OPENPAY

    /**Subscription Methods*/

    fun saveSubscription( subscription: ESubscription )
            = repositoryPayments.saveSubscription( subscription )

    fun getSubscription(function: (SubscriptionResponse?) -> Unit )
            = repositoryPayments.getSubscription( function )

    fun getLocalSubscriptions(function: (List<ESubscription>?) -> Unit )
            = repositoryPayments.getLocalSubscription( function )

    fun cancelSubscription( subscriptionID: String, function: (SubscriptionResponse?) -> Unit )
            = repositoryPayments.cancelSubscription( subscriptionID, function )


    /**Cards Methods*/

    fun getCardsLiveData()
            = repositoryPayments.getCardsLiveData()

    fun saveCards(list: List<ECard>)
            = repositoryPayments.saveCardList( list )

    fun downloadCards(function: (List<ECard>?) -> Unit )
            = repositoryPayments.downloadCards( function )


    /**Plan Methods*/

    fun savePlan ( plan: EPlan) = repositoryPayments.savePlan( plan )

}