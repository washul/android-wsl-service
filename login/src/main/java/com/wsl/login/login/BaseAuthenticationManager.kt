package com.wsl.login.login

import com.domain.domain.login.models.LoginResponse
import com.domain.domain.login.models.RegisterResponse
import com.domain.domain.login.models.SensitiveTokens
import com.domain.domain.login.models.User
import com.utils.utils.Failure
import com.utils.utils.Result

abstract class BaseAuthenticationManager {

    abstract suspend fun localSignIn(): Result<Failure, Boolean>
    abstract suspend fun login(email: String, password: String): Result<Failure, Boolean>
    abstract suspend fun saveUserOrUpdate(user: User): Result<Failure, Boolean>
    abstract suspend fun registerUser(user: User): Result<Failure, Boolean>
    abstract suspend fun updateUser(user: User): Result<Failure, Boolean>
    abstract suspend fun getUser(): Result<Failure, User?>
    abstract suspend fun logOut(): Result<Failure, Boolean>
    abstract fun getSensitiveTokens(): Result<Failure, SensitiveTokens>
    abstract suspend fun setTokenUSer(token: String): Result<Failure, Boolean>
    abstract suspend fun setTokenDevice(tokenDevice: String): Result<Failure, Boolean>
    abstract suspend fun setUserID(userID: String): Result<Failure, Boolean>

}