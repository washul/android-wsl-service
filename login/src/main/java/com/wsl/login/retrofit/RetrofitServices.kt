package com.wsl.login.Utils.retrofit

import com.wsl.login.model.EUser
import com.wsl.login.retrofit.LoginResponse
import com.wsl.login.retrofit.RegisterResponse
import io.reactivex.Observable
import retrofit2.http.*

interface RetrofitServices {

    @POST("login/")
    fun login(@Body parameters: EUser): Observable<LoginResponse>

    @GET("login-auto/")
    fun loginAuto(): Observable<LoginResponse>


    @POST("register/")
    fun registerUser(@Body user: EUser ): Observable<RegisterResponse>

}