package com.wsl.login.helpers

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class WSPreferences @Inject constructor (context: Context ) {

    companion object{
        const val PREFS_NAME = "com.wsl.login"
        const val UUID_USER_PARAMETER = "UUID_USER_PARAMETER"
        const val TOKEN_USER_PARAMETER = "TOKEN_USER_PARAMETER"
        const val TOKEN_DEVICE_PARAMETER = "TOKEN_DEVICE_PARAMETER"
        const val APP_ID = "APP_ID"
    }

    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var appID: String
        get() = prefs.getString(APP_ID, "").toString()
        set(value) = prefs.edit().putString(APP_ID, value).apply()

    var userID: String
        get() = prefs.getString(UUID_USER_PARAMETER, "").toString()
        set(value) = prefs.edit().putString(UUID_USER_PARAMETER, value).apply()

    var tokenUser: String
        get() = prefs.getString(TOKEN_USER_PARAMETER, "").toString()
        set(value) = prefs.edit().putString(TOKEN_USER_PARAMETER, value).apply()

    var tokenDevice: String
        get() = prefs.getString(TOKEN_DEVICE_PARAMETER, "").toString()
        set(value) = prefs.edit().putString(TOKEN_DEVICE_PARAMETER, value).apply()

}