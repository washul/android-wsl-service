package com.wsl.login

import com.wsl.login.model.EUser

interface ILoginService {

    fun signIn( user: EUser )

    fun register( user: EUser )

}