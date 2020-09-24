package com.wsl.login.helpers

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.provider.Settings
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProviders
import com.facebook.FacebookSdk
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import com.wsl.login.R
import com.wsl.login.WSLoginActivity
import com.wsl.login.dagger.DaggerApplication
import com.wsl.login.dagger.RetroViewModelFactory
import com.wsl.login.view_model.LoginViewModel
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

fun View.showSnackBarMessage( message: String ){

    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        .setBackgroundTint(resources.getColor(R.color.colorAccent))
        .show()

}

class ProgressBarCustom {

    lateinit var progressBar: ProgressBar
    lateinit var activity: Activity

    companion object {

        lateinit var instance: ProgressBarCustom

        internal fun build( activity: Activity, progressBar: ProgressBar ): ProgressBarCustom {

            if ( !::instance.isInitialized ){

                instance = ProgressBarCustom().apply {

                    this.progressBar = progressBar
                    this.activity = activity

                }

            }

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

fun WSLoginActivity.initDaggerViewModel(): LoginViewModel {

    val appComponent = DaggerApplication().initDaggerComponent(application)
    appComponent.inject(this)

    val viewModelFactory = RetroViewModelFactory(appComponent)

    return ViewModelProviders
        .of(this, viewModelFactory)
        .get(LoginViewModel::class.java)

}



