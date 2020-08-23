package com.wsl.login.retrofit

import com.wsl.login.model.EUser

data class LoginResponse(

    var user: EUser,
    var token: String,
    var message: String

)

data class RegisterResponse(

    var uuid: String,
    var message: String

)