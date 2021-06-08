package com.wsl.login.helpers

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.wsl.login.R


fun ImageView.buildResource(resource: Int, context: Context){

    try {
        Picasso.with(context)
            .load(resource)
            .fit()
            .into(this)
    }catch ( e: java.lang.Exception ){
        e.printStackTrace()
    }

}

fun Button.useAsRegisterButton(): Button {
    val firstText = this.context.getString(R.string.no_tienes_una_cuenta)
    val secondText = this.context.getString(R.string.crear_cuenta)

    val spannable = SpannableString("$firstText\n$secondText")
    spannable.setSpan(
        ForegroundColorSpan(resources.getColor(R.color.colorAccent, this.context.theme)),
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

    this.text = spannable
    return this
}

// Network Check
fun isOnlineNet(): Boolean {
    try {
        val p = Runtime.getRuntime().exec("ping -c 1 www.google.es")
        val `val` = p.waitFor()
        return `val` == 0
    } catch (e: java.lang.Exception) {
        e.printStackTrace()
    }
    return false
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

fun EditText.requestFocusToWrite() {
    this.requestFocus()
    val inputMethodManager: InputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}