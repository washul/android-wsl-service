package com.utils.utils

import android.util.Log

object L {
    private val enableLogging = true

    /**
     * @see android.util.Log.e
     */
    fun e(tag: String?, message: String?) {
        if (enableLogging) {
            Log.e(tag, message!!)
        }
    }

    /**
     * @see android.util.Log.e
     */
    fun e(tag: String?, message: String?, ex: Throwable?) {
        if (enableLogging) {
            Log.e(tag, message, ex)
        }
    }

    /**
     * @see android.util.Log.d
     */
    fun d(tag: String?, message: String?) {
        if (enableLogging) {
            Log.d(tag, message!!)
        }
    }

    /**
     * @see android.util.Log.i
     */
    fun i(tag: String?, message: String?) {
        if (enableLogging) {
            Log.i(tag, message!!)
        }
    }

    /**
     * @see android.util.Log.w
     */
    fun w(tag: String?, message: String?) {
        if (enableLogging) {
            Log.w(tag, message!!)
        }
    }

    /**
     * @see android.util.Log.w
     */
    fun w(tag: String?, message: String?, ex: Throwable?) {
        if (enableLogging) {
            Log.w(tag, message, ex)
        }
    }

    /**
     * @see android.util.Log.v
     */
    fun v(tag: String?, message: String?) {
        if (enableLogging) {
            Log.v(tag, message!!)
        }
    }

    /**
     * @see android.util.Log.wtf
     */
    fun wtf(tag: String?, message: String?) {
        if (enableLogging) {
            Log.wtf(tag, message)
        }
    }
}