package com.wsl.login.retrofit

import com.wsl.utils.database.EUser
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitServices {

    @POST("login/")
    fun login(@Body parameters: EUser): Observable<LoginResponse>

    @GET("login-auto/")
    fun loginAuto(): Observable<LoginResponse>


    @POST("register/")
    fun registerUser(@Body user: EUser ): Observable<RegisterResponse>

}