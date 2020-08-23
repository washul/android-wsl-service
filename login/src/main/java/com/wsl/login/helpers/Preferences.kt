package com.wsl.login.helpers

import android.content.Context
import android.content.SharedPreferences

class Preferences( context: Context ) {

    companion object{
        const val PREFS_NAME = "com.wsl.login"
        const val TOKEN_PARAMETER = "TOKEN_PARAMETER"
    }

    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var tokenUser: String?
        get() = prefs.getString(TOKEN_PARAMETER, "")
        set(value) = prefs.edit().putString(TOKEN_PARAMETER, value).apply()

}