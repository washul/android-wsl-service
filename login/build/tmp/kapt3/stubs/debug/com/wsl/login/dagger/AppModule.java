package com.wsl.login.dagger;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ApplicationComponent.class})
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\u001a\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u000f0\u000f2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u001e\u001a\u00020\u001f2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u001a\u0010 \u001a\n \u0005*\u0004\u0018\u00010!0!2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\""}, d2 = {"Lcom/wsl/login/dagger/AppModule;", "", "()V", "GoogleSiginInOptions", "Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "appDataBase", "Lcom/wsl/login/database/AppDataBase;", "callbackManager", "Lcom/facebook/CallbackManager;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mGoogleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "prefs", "Lcom/wsl/login/helpers/WSPreferences;", "provideConfigClass", "Lcom/wsl/login/config/Config;", "provideRetrofit", "Lretrofit2/Retrofit;", "provideViewModelLogin", "Lcom/wsl/login/login/view_model/WSLoginViewModel;", "provideViewModelPayments", "Lcom/wsl/login/payments/viewmodel/WSPaymentViewModel;", "provideViewModelProfile", "Lcom/wsl/login/profile/view_model/WSProfileViewModel;", "repositoryLogin", "Lcom/wsl/login/login/view_model/RepositoryLogin;", "repositoryPayments", "Lcom/wsl/login/payments/viewmodel/RepositoryPayments;", "retrofitServices", "Lcom/wsl/login/retrofit/RetrofitServices;", "login_debug"})
@dagger.Module
public final class AppModule {
    @org.jetbrains.annotations.NotNull
    public static final com.wsl.login.dagger.AppModule INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.wsl.login.login.view_model.WSLoginViewModel provideViewModelLogin(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.wsl.login.payments.viewmodel.WSPaymentViewModel provideViewModelPayments(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.wsl.login.profile.view_model.WSProfileViewModel provideViewModelProfile(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.wsl.login.helpers.WSPreferences prefs(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.wsl.login.login.view_model.RepositoryLogin repositoryLogin(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.wsl.login.payments.viewmodel.RepositoryPayments repositoryPayments(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.wsl.login.database.AppDataBase appDataBase(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @dagger.Provides
    @javax.inject.Singleton
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    public final com.wsl.login.retrofit.RetrofitServices retrofitServices(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.facebook.CallbackManager callbackManager() {
        return null;
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    public final com.google.android.gms.auth.api.signin.GoogleSignInOptions GoogleSiginInOptions(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    public final com.google.android.gms.auth.api.signin.GoogleSignInClient mGoogleSignInClient(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.google.firebase.auth.FirebaseAuth firebaseAuth() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.wsl.login.config.Config provideConfigClass(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    private AppModule() {
        super();
    }
}