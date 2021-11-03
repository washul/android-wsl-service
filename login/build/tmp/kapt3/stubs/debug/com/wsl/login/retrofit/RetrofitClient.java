package com.wsl.login.retrofit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0003\u000b\f\rB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/wsl/login/retrofit/RetrofitClient;", "", "prefs", "Lcom/wsl/login/helpers/WSPreferences;", "(Lcom/wsl/login/helpers/WSPreferences;)V", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "setRetrofit", "(Lretrofit2/Retrofit;)V", "Companion", "RequestInterceptorAddAppID", "RequestInterceptorAddHeaders", "login_debug"})
public final class RetrofitClient {
    @org.jetbrains.annotations.Nullable
    private retrofit2.Retrofit retrofit;
    private final com.wsl.login.helpers.WSPreferences prefs = null;
    public static com.wsl.login.retrofit.RetrofitClient instance;
    @org.jetbrains.annotations.NotNull
    public static final com.wsl.login.retrofit.RetrofitClient.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable
    public final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    public final void setRetrofit(@org.jetbrains.annotations.Nullable
    retrofit2.Retrofit p0) {
    }
    
    @javax.inject.Inject
    public RetrofitClient(@org.jetbrains.annotations.NotNull
    com.wsl.login.helpers.WSPreferences prefs) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/wsl/login/retrofit/RetrofitClient$RequestInterceptorAddHeaders;", "Lokhttp3/Interceptor;", "(Lcom/wsl/login/retrofit/RetrofitClient;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "login_debug"})
    public final class RequestInterceptorAddHeaders implements okhttp3.Interceptor {
        
        @org.jetbrains.annotations.Nullable
        @java.lang.Override
        public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull
        okhttp3.Interceptor.Chain chain) {
            return null;
        }
        
        public RequestInterceptorAddHeaders() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/wsl/login/retrofit/RetrofitClient$RequestInterceptorAddAppID;", "Lokhttp3/Interceptor;", "(Lcom/wsl/login/retrofit/RetrofitClient;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "login_debug"})
    public final class RequestInterceptorAddAppID implements okhttp3.Interceptor {
        
        @org.jetbrains.annotations.Nullable
        @java.lang.Override
        public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull
        okhttp3.Interceptor.Chain chain) {
            return null;
        }
        
        public RequestInterceptorAddAppID() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/wsl/login/retrofit/RetrofitClient$Companion;", "", "()V", "instance", "Lcom/wsl/login/retrofit/RetrofitClient;", "getInstance", "()Lcom/wsl/login/retrofit/RetrofitClient;", "setInstance", "(Lcom/wsl/login/retrofit/RetrofitClient;)V", "build", "prefs", "Lcom/wsl/login/helpers/WSPreferences;", "buildRetrofit", "", "login_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull
        public final com.wsl.login.retrofit.RetrofitClient getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.NotNull
        com.wsl.login.retrofit.RetrofitClient p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wsl.login.retrofit.RetrofitClient build(@org.jetbrains.annotations.NotNull
        com.wsl.login.helpers.WSPreferences prefs) {
            return null;
        }
        
        private final void buildRetrofit() {
        }
        
        private Companion() {
            super();
        }
    }
}