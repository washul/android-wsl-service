package com.wsl.login.retrofit

import com.wsl.login.database.CardsResponse
import com.wsl.login.database.ECard
import com.wsl.login.database.EUser
import io.reactivex.Observable
import org.json.JSONObject
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


    @GET("get-cards-list/")
    fun getCards(): Observable<CardsResponse>

    @POST("add-cards/")
    fun addCard(@Body card: EUser ): Observable<CardsResponse>

    @POST("delete-card/")
    fun deleteCard(@Body model: ECard ): Observable<CardsResponse>

    @POST("register-card-to-openpay-account/")
    fun registerCard(@Body model: JSONObject): Observable<CardsResponse>
}