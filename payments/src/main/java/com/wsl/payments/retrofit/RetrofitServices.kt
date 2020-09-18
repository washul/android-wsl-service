package com.wsl.payments.retrofit


import io.reactivex.Observable
import retrofit2.http.*
import javax.inject.Inject

interface RetrofitServices {

//    @POST("login/")
//    fun login(@Body parameters: EUser): Observable<LoginResponse>
//
    @GET("login-auto/")
    fun loginAuto(): Observable<LoginResponse>
//
//
//    @POST("register/")
//    fun registerUser(@Body user: EUser ): Observable<RegisterResponse>

}