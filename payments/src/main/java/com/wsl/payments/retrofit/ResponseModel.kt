package com.wsl.payments.retrofit

import com.wsl.payments.model.EUser

data class LoginResponse(

    var user: EUser,
    var token: String,
    var message: String,
    var auth: Boolean

)