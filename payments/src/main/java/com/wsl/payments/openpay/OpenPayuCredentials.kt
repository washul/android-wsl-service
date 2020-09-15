package com.wsl.payments.openpay

import mx.openpay.android.Openpay

class OpenPayuCredentials {

    private var openPay: Openpay = Openpay( "m17sk8mrgcnnxi7k8hvx", "pk_9f03548842e44f30bdfaf393d2aa0ca0", false )

    fun getOpenPay(): Openpay = openPay

}