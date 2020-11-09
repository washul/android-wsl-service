package com.wsl.login.helpers

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkRequest
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import com.squareup.picasso.Picasso
import com.wsl.login.R
import org.jetbrains.anko.runOnUiThread


fun ImageView.buildResource(resource: Int, context: Context){

    try {
        Picasso.with(context)
            .load(resource)
            .fit()
            .onlyScaleDown()
            .into(this)
    }catch ( e: java.lang.Exception ){
        e.printStackTrace()
    }

}

fun Context.buildRegisterText(registrar: Button): Button {
    val firstText = getString(R.string.no_tienes_una_cuenta)
    val secondText = getString(R.string.crear_cuenta)

    val spannable = SpannableString("$firstText\n$secondText")
    spannable.setSpan(
        ForegroundColorSpan(resources.getColor(R.color.colorAccent)),
        firstText.length + 1,
        (firstText.length + 1) + secondText.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    spannable.setSpan(
        RelativeSizeSpan(2f),
        firstText.length + 1,
        (firstText.length + 1) + secondText.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    registrar.text = spannable

    return registrar
}

// Network Check
fun Context.registerNetworkCallback(isNetworkAvailable: MutableLiveData<Boolean>) {
    try {

        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val builder = NetworkRequest.Builder()

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {

                connectivityManager.registerDefaultNetworkCallback(object : NetworkCallback() {
                    override fun onAvailable(network: Network?) {
                        runOnUiThread { isNetworkAvailable.value = true }

                    }

                    override fun onLost(network: Network?) {
                        runOnUiThread { isNetworkAvailable.value = true }
                    }
                })
            }

        }else {

            val networkInfo = connectivityManager.activeNetworkInfo
            networkInfo.isConnected

            isNetworkAvailable.value = networkInfo.isConnected

        }

    } catch (e: Exception) {
        isNetworkAvailable.value = false
    }
}

fun Drawable.getBitmap(): Bitmap {
    val bitmap = Bitmap.createBitmap(
        this.intrinsicWidth,
        this.intrinsicHeight, Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(bitmap)
    this.setBounds(0, 0, canvas.width, canvas.height)
    this.draw(canvas)
    return bitmap
}