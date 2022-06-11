package com.domain.domain.login.models


data class LoginResponse(

    var user: User? = null,
    var token: String? = null,
    var message: String? = null,
    var auth: Boolean? = null

)