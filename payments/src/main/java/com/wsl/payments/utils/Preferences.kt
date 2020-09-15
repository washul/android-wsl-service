package com.wsl.payments.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class Preferences @Inject constructor ( context: Context ) {

    companion object{
        const val PREFS_NAME = "com.wsl.payments"
        const val TOKEN_PARAMETER = "TOKEN_PARAMETER"
    }

    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var tokenUser: String
        get() = prefs.getString(TOKEN_PARAMETER, "").toString()
        set(value) = prefs.edit().putString(TOKEN_PARAMETER, value).apply()

}