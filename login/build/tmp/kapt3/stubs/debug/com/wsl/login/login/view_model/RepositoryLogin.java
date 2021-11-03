package com.wsl.login.login.view_model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00130\u0015J\u0006\u0010\u0017\u001a\u00020\u0016J\'\u0010\u0018\u001a\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u00130\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u001cJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016J\u001a\u0010\u001e\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00130\u0015J/\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00162\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00130\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\'\u0010\"\u001a\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020\u00130\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ/\u0010$\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00162\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020\u00130\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u000e\u0010&\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0016J/\u0010\'\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00162\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020\u00130\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006("}, d2 = {"Lcom/wsl/login/login/view_model/RepositoryLogin;", "", "db", "Lcom/wsl/login/database/AppDataBase;", "prefs", "Lcom/wsl/login/helpers/WSPreferences;", "service", "Lcom/wsl/login/retrofit/RetrofitServices;", "(Lcom/wsl/login/database/AppDataBase;Lcom/wsl/login/helpers/WSPreferences;Lcom/wsl/login/retrofit/RetrofitServices;)V", "daoUser", "Lcom/wsl/login/database/dao/DAOUser;", "isNetworkAvailable", "", "()Z", "getPrefs", "()Lcom/wsl/login/helpers/WSPreferences;", "setPrefs", "(Lcom/wsl/login/helpers/WSPreferences;)V", "getLocalUserAsync", "", "function", "Lkotlin/Function1;", "Lcom/wsl/login/database/entities/EUser;", "getLocalUserNoAsync", "getUser", "Lcom/wsl/login/retrofit/LoginResponse;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserLiveData", "Landroidx/lifecycle/LiveData;", "localSignIn", "logOut", "login", "user", "(Lcom/wsl/login/database/entities/EUser;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginAuto", "", "registerUser", "Lcom/wsl/login/retrofit/RegisterResponse;", "saveUserOrUpdate", "updateUser", "login_debug"})
public final class RepositoryLogin {
    private com.wsl.login.database.dao.DAOUser daoUser;
    private final boolean isNetworkAvailable = false;
    @org.jetbrains.annotations.NotNull
    private com.wsl.login.helpers.WSPreferences prefs;
    private com.wsl.login.retrofit.RetrofitServices service;
    
    public final boolean isNetworkAvailable() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.wsl.login.database.entities.EUser localSignIn() {
        return null;
    }
    
    public final void saveUserOrUpdate(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EUser user) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.wsl.login.database.entities.EUser> getUserLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wsl.login.database.entities.EUser getLocalUserNoAsync() {
        return null;
    }
    
    public final void getLocalUserAsync(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.EUser, kotlin.Unit> function) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object login(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EUser user, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.EUser, kotlin.Unit> function, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object loginAuto(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> function, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object registerUser(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EUser user, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.retrofit.RegisterResponse, kotlin.Unit> function, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateUser(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EUser user, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.retrofit.RegisterResponse, kotlin.Unit> function, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getUser(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.retrofit.LoginResponse, kotlin.Unit> function, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public final void logOut(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> function) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wsl.login.helpers.WSPreferences getPrefs() {
        return null;
    }
    
    public final void setPrefs(@org.jetbrains.annotations.NotNull
    com.wsl.login.helpers.WSPreferences p0) {
    }
    
    @javax.inject.Inject
    public RepositoryLogin(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.AppDataBase db, @org.jetbrains.annotations.NotNull
    com.wsl.login.helpers.WSPreferences prefs, @org.jetbrains.annotations.NotNull
    com.wsl.login.retrofit.RetrofitServices service) {
        super();
    }
}