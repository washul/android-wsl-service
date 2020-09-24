package com.wsl.login.utils

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.buildResource(resource: Int, context: Context){

    Picasso.with( context )
        .load( resource )
        .into( this )

}
