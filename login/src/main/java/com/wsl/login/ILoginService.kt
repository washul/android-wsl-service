package com.wsl.login

import com.wsl.login.database.EUser

interface ILoginService {

    fun signIn( user: EUser )

    fun register( user: EUser )

}