package com.wsl.data.login.repository

import com.domain.domain.login.models.LoginResponse
import com.domain.domain.login.models.RegisterResponse
import com.utils.utils.Failure
import com.utils.utils.Result
import com.wsl.data.db.entities.EUser
import com.wsl.data.utils.CommonRequest
import com.wsl.data.retrofit.RetrofitServices
import retrofit2.Retrofit

class RemoteDataSource(
    private val retrofitClient: Retrofit
) {

    private val service = retrofitClient.create(RetrofitServices::class.java)

    suspend fun login(
        user: EUser
    ): Result<Failure, LoginResponse> {
        return CommonRequest(
            { service.login( parameters = user ) },
            LoginResponse()
        )
    }

    suspend fun getUser(): Result<Failure, LoginResponse> {
        return CommonRequest(
            { service.getUser() },
            LoginResponse()
        )
    }

    suspend fun registerUser(
        user: EUser
    ): Result<Failure, RegisterResponse> {
        return CommonRequest(
            { service.registerUser( user ) },
            RegisterResponse()
        )
    }

    suspend fun updateUser(
        user: EUser
    ): Result<Failure, RegisterResponse> {
        return CommonRequest(
            { service.updateUser( user )},
            RegisterResponse()
        )
    }

    companion object {
        val TAG = "RemoteDataSource"
    }

}