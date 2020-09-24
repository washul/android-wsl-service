package com.wsl.login.payments.openpay

import mx.openpay.android.Openpay

class OpenPayuCredentials {

    private var openPay: Openpay = Openpay( "mwbvnryl7907btacqrra", "pk_d653b43c48c5456cbf9f3b7c51907a1a", false )

    fun getOpenPay(): Openpay = openPay

}