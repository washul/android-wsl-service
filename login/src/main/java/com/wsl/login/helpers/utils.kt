package com.wsl.login.helpers

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.provider.Settings
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.fragment.app.FragmentActivity
import com.facebook.FacebookSdk
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import com.wsl.login.R
import com.wsl.login.login.WSLoginActivity
import kotlinx.android.synthetic.main.activity_login.*
import java.math.BigInteger
import java.security.MessageDigest


fun ImageView.changeImageTo(image: Int, picasso: Picasso){
    picasso.load( image ).fit().into( this )
}

@SuppressLint("HardwareIds")
fun Context.getDeviceID() = Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID).md5()


fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun String.sha256(): String {
    val md = MessageDigest.getInstance("SHA-256")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun WSLoginActivity.showSnackBarMessage( message: String ){

    this.runOnUiThread {
        Snackbar.make(login_view, message, Snackbar.LENGTH_LONG)
            .setBackgroundTint(resources.getColor(R.color.colorAccent))
            .show()
    }

}

fun View.showSnackBarMessage(message: String ){

    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        .setBackgroundTint(resources.getColor(R.color.colorAccent))
        .show()

}

fun View.showSnackBarMessage(message: String, actionMessage: String, function: () -> Unit){

    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        .setBackgroundTint(resources.getColor(R.color.colorAccent))
        .setAction( actionMessage ) {
            function()
        }
        .show()

}

class WSProgressBarCustom {

    lateinit var progressBar: ProgressBar
    lateinit var activity: Activity

    companion object {

        @SuppressLint("StaticFieldLeak")
        lateinit var instance: WSProgressBarCustom

        internal fun build( activity: Activity?, progressBar: ProgressBar ): WSProgressBarCustom {
            if ( !::instance.isInitialized ){
                instance = WSProgressBarCustom().apply {
                    this.progressBar = progressBar
                    this.activity = activity ?: return@apply
                }
            }
            return instance
        }

        internal fun build( activity: FragmentActivity?, progressBar: ProgressBar ): WSProgressBarCustom {
            if ( !::instance.isInitialized ){
                instance = WSProgressBarCustom().apply {
                    this.progressBar = progressBar
                    this.activity = activity ?: return@apply
                }
            }
            instance.dismiss()
            return instance
        }
    }

    fun show(){
        this.progressBar.visibility = View.VISIBLE
        activity.window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }
    fun dismiss(){
        this.progressBar.visibility = View.GONE
        activity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }
}

fun WSLoginActivity.initFacebookSDK() = FacebookSdk.sdkInitialize(applicationContext)



