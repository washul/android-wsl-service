package com.wsl.login

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.changeImageTo(image: Int, picasso: Picasso){
    picasso.load( image ).fit().into( this )
}