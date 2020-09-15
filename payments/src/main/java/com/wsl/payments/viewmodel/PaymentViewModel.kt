package com.wsl.payments.viewmodel

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class PaymentViewModel @Inject constructor(): ViewModel() {

    @Inject
    lateinit var repository: RepositoryPayments


}