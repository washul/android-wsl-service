package com.wsl.login.retrofit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\t2\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\t2\b\b\u0001\u0010\u001f\u001a\u00020\u0015H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J!\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010!\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0\t2\b\b\u0001\u0010\u001f\u001a\u00020\u0015H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/wsl/login/retrofit/RetrofitServices;", "", "cancelSubscription", "Lio/reactivex/Observable;", "Lcom/wsl/login/database/entities/SubscriptionResponse;", "subscriptionID", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createOpenPayCustomer", "Lretrofit2/Response;", "Lcom/wsl/login/database/entities/CardsResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCards", "getPlan", "Lcom/wsl/login/database/entities/PlanResponse;", "getSubscription", "getUser", "Lcom/wsl/login/retrofit/LoginResponse;", "login", "Lokhttp3/ResponseBody;", "parameters", "Lcom/wsl/login/database/entities/EUser;", "(Lcom/wsl/login/database/entities/EUser;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginAuto", "paySubscription", "model", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerCard", "registerUser", "Lcom/wsl/login/retrofit/RegisterResponse;", "user", "removeCard", "card_id", "updateUser", "login_debug"})
public abstract interface RetrofitServices {
    
    /**
     * Login Methods
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "login/")
    public abstract java.lang.Object login(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.wsl.login.database.entities.EUser parameters, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> p1);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "login-auto/")
    public abstract java.lang.Object loginAuto(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> p0);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "register/")
    public abstract java.lang.Object registerUser(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.wsl.login.database.entities.EUser user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.wsl.login.retrofit.RegisterResponse>> p1);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "update-user/")
    public abstract java.lang.Object updateUser(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.wsl.login.database.entities.EUser user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.wsl.login.retrofit.RegisterResponse>> p1);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "create-openpay-account/")
    public abstract java.lang.Object createOpenPayCustomer(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.wsl.login.database.entities.CardsResponse>> p0);
    
    /**
     * Plan Methods
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "internal/get-plans-list/")
    public abstract java.lang.Object getPlan(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super io.reactivex.Observable<com.wsl.login.database.entities.PlanResponse>> p0);
    
    /**
     * Subscription Methods
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "pay-subscription/")
    public abstract java.lang.Object paySubscription(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    org.json.JSONObject model, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super io.reactivex.Observable<com.wsl.login.database.entities.SubscriptionResponse>> p1);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "get-subscription/")
    public abstract java.lang.Object getSubscription(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super io.reactivex.Observable<com.wsl.login.database.entities.SubscriptionResponse>> p0);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "cancel-subscription/")
    public abstract java.lang.Object cancelSubscription(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "subscriptionID")
    java.lang.String subscriptionID, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super io.reactivex.Observable<com.wsl.login.database.entities.SubscriptionResponse>> p1);
    
    /**
     * Cards Methods
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "get-cards-list/")
    public abstract java.lang.Object getCards(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super io.reactivex.Observable<com.wsl.login.database.entities.CardsResponse>> p0);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "remove-card/")
    public abstract java.lang.Object removeCard(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "card_id")
    java.lang.String card_id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super io.reactivex.Observable<com.wsl.login.database.entities.CardsResponse>> p1);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "register-card-to-openpay-account/")
    public abstract java.lang.Object registerCard(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    org.json.JSONObject model, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super io.reactivex.Observable<com.wsl.login.database.entities.CardsResponse>> p1);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "get-user/")
    public abstract java.lang.Object getUser(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super io.reactivex.Observable<com.wsl.login.retrofit.LoginResponse>> p0);
}