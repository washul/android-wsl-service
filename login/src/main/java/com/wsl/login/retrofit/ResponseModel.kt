package com.wsl.login.retrofit

import com.wsl.login.database.EUser

data class LoginResponse(

    var user: EUser,
    var token: String,
    var message: String,
    var auth: Boolean

)

data class RegisterResponse(

    var uuid: String,
    val token: String,
    var message: String

)