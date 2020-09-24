package com.wsl.login

import com.wsl.utils.database.EUser

interface ILoginService {

    fun signIn( user: EUser )

    fun register( user: EUser )

}