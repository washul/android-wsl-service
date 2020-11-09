package com.wsl.login.retrofit

import com.wsl.login.database.entities.*
import io.reactivex.Observable
import org.json.JSONObject
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitServices {

    /**Login Methods*/

    @POST("login/")
    fun login(@Body parameters: EUser): Observable<LoginResponse>

    @GET("login-auto/")
    fun loginAuto(): Observable<LoginResponse>


    @POST("register/")
    fun registerUser(@Body user: EUser): Observable<RegisterResponse>

    @POST("update-user/")
    fun updateUser(@Body user: EUser): Observable<RegisterResponse>

    @GET("create-openpay-account/")
    fun createOpenPayCustomer(): Observable<CardsResponse>

    /**Plan Methods*/

    @GET("internal/get-plans-list/")
    fun getPlan(): Observable<PlanResponse>

    /**Subscription Methods*/

    @POST("pay-subscription/")
    fun paySubscription(@Body model: JSONObject): Observable<SubscriptionResponse>

    @GET("get-subscription/")
    fun getSubscription(): Observable<SubscriptionResponse>

    @GET("cancel-subscription/")
    fun cancelSubscription(@Query("subscriptionID") subscriptionID: String ): Observable<SubscriptionResponse>

    /**Cards Methods*/

    @GET("get-cards-list/")
    fun getCards(): Observable<CardsResponse>

    @GET("remove-card/")
    fun removeCard(@Query("card_id") card_id: String): Observable<CardsResponse>

    @POST("register-card-to-openpay-account/")
    fun registerCard(@Body model: JSONObject): Observable<CardsResponse>

    @GET("get-user/")
    fun getUser(): Observable<LoginResponse>


}