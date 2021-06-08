package com.wsl.login.retrofit

import com.wsl.login.database.entities.*
import io.reactivex.Observable
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitServices {

    /**Login Methods*/

    @POST("login/")
    suspend fun login(@Body parameters: EUser): Response<LoginResponse>

    @GET("login-auto/")
    suspend fun loginAuto(): Response<LoginResponse>


    @POST("register/")
    suspend fun registerUser(@Body user: EUser): Response<RegisterResponse>

    @POST("update-user/")
    suspend fun updateUser(@Body user: EUser): Response<RegisterResponse>

    @GET("create-openpay-account/")
    suspend fun createOpenPayCustomer(): Response<CardsResponse>

    /**Plan Methods*/

    @GET("internal/get-plans-list/")
    suspend fun getPlan(): Observable<PlanResponse>

    /**Subscription Methods*/

    @POST("pay-subscription/")
    suspend fun paySubscription(@Body model: JSONObject): Observable<SubscriptionResponse>

    @GET("get-subscription/")
    suspend fun getSubscription(): Observable<SubscriptionResponse>

    @GET("cancel-subscription/")
    suspend fun cancelSubscription(@Query("subscriptionID") subscriptionID: String ): Observable<SubscriptionResponse>

    /**Cards Methods*/

    @GET("get-cards-list/")
    suspend fun getCards(): Observable<CardsResponse>

    @GET("remove-card/")
    suspend fun removeCard(@Query("card_id") card_id: String): Observable<CardsResponse>

    @POST("register-card-to-openpay-account/")
    suspend fun registerCard(@Body model: JSONObject): Observable<CardsResponse>

    @GET("get-user/")
    suspend fun getUser(): Observable<LoginResponse>
}