package com.wsl.payments.retrofit

import com.wsl.utils.database.EUser

data class LoginResponse(

    var user: EUser,
    var token: String,
    var message: String,
    var auth: Boolean

)