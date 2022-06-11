package com.domain.domain.login.repository

import com.domain.domain.login.models.LoginResponse
import com.domain.domain.login.models.RegisterResponse
import com.domain.domain.login.models.SensitiveTokens
import com.domain.domain.login.models.User
import com.utils.utils.Failure
import com.utils.utils.Result

interface RepositoryLogin {
    suspend fun localSignIn(): Result<Failure, String>
    suspend fun login(email: String, password: String): Result<Failure, LoginResponse>
    suspend fun saveUserOrUpdate(user: User): Result<Failure, Boolean>
    suspend fun registerUser(user: User): Result<Failure, RegisterResponse>
    suspend fun updateUser(user: User): Result<Failure, RegisterResponse>
    suspend fun getUser(): Result<Failure, LoginResponse>
    fun logOut(): Result<Failure, Boolean>

    fun getSensitiveTokens(): Result<Failure, SensitiveTokens>
    fun setTokenUSer(token: String): Result<Failure, Boolean>
    fun setTokenDevice(tokenDevice: String): Result<Failure, Boolean>
    fun setUserID(userID: String): Result<Failure, Boolean>
}

