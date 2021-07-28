package com.wsl.login.helpers

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String) {
    Picasso.with(this.context)
        .load(url)
        .fit()
        .into(this)
}