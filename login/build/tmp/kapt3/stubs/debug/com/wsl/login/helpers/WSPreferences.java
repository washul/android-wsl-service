package com.wsl.login.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR$\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR$\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/wsl/login/helpers/WSPreferences;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "appID", "getAppID", "()Ljava/lang/String;", "setAppID", "(Ljava/lang/String;)V", "prefs", "Landroid/content/SharedPreferences;", "tokenDevice", "getTokenDevice", "setTokenDevice", "tokenUser", "getTokenUser", "setTokenUser", "userID", "getUserID", "setUserID", "Companion", "login_debug"})
public final class WSPreferences {
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PREFS_NAME = "com.wsl.login";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String UUID_USER_PARAMETER = "UUID_USER_PARAMETER";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TOKEN_USER_PARAMETER = "TOKEN_USER_PARAMETER";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TOKEN_DEVICE_PARAMETER = "TOKEN_DEVICE_PARAMETER";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String APP_ID = "APP_ID";
    @org.jetbrains.annotations.NotNull
    public static final com.wsl.login.helpers.WSPreferences.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAppID() {
        return null;
    }
    
    public final void setAppID(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserID() {
        return null;
    }
    
    public final void setUserID(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTokenUser() {
        return null;
    }
    
    public final void setTokenUser(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTokenDevice() {
        return null;
    }
    
    public final void setTokenDevice(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @javax.inject.Inject
    public WSPreferences(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/wsl/login/helpers/WSPreferences$Companion;", "", "()V", "APP_ID", "", "PREFS_NAME", "TOKEN_DEVICE_PARAMETER", "TOKEN_USER_PARAMETER", "UUID_USER_PARAMETER", "login_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}