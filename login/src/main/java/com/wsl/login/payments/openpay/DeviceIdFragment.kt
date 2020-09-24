package com.wsl.login.payments.openpay

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

class DeviceIdFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.retainInstance = true

    }

    fun getDevicedId(): String {

        val openpay = OpenPayuCredentials().getOpenPay()
        val deviceIdString = openpay.deviceCollectorDefaultImpl.setup( this.activity!! )

        if ( deviceIdString == null ){

            printMsg( openpay.deviceCollectorDefaultImpl.errorMessage, this.activity )

        }else{

            printMsg( deviceIdString, this.activity )

        }

        return deviceIdString

    }

    fun printMsg( msg: String, activity: Activity? ){

        activity?.runOnUiThread { Log.d("ADD_CARD_ACTIVITY", msg ) }

    }

}