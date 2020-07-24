package com.wsl.login.view_model

import androidx.lifecycle.ViewModel
import com.wsl.login.model.EUser

class LoginViewModel: ViewModel() {

    private val repository = RepositoryLogin()

    var user: EUser? = null

    fun login( user: EUser, function: (EUser?) -> Unit ) = repository.login( user, function )

    fun register( user: EUser, function: (Boolean) -> Unit ) = repository.register( user, function )

}