package com.wsl.login.payments.viewmodel

import androidx.lifecycle.ViewModel
import com.wsl.login.database.ECard
import com.wsl.login.database.EUser
import javax.inject.Inject

class PaymentViewModel @Inject constructor(): ViewModel() {

    @Inject
    lateinit var repository: RepositoryPayments

    fun getUserLiveData() = repository.getLocalUserLiveData()

    fun saveCards(list: List<ECard>) = repository.saveCardList( list )

    fun registerCard( device_session_id: String, token_id: String ) = repository.registerCard( device_session_id, token_id )

    fun downloadCards(function: (List<ECard>?) -> Unit ) = repository.downloadCards( function )


    fun getCardsLiveData() = repository.getCardsLiveData()


}