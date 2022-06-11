package com.domain.domain.login.models

data class RegisterResponse(

    var uuid_user: String? = null,
    val token: String? = null,
    var message: String? = null

)