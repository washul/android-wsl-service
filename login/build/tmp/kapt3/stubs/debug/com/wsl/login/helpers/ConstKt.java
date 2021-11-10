package com.wsl.login.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"ID_CASH_WALLET", "", "RC_SIGN_IN", "", "TAG", "URL_BASE", "WSL_ACTION_PARAM_NAME", "WSL_FLAG_NAME", "WSL_LOGIN_ACTION_AUTO_LOG_OUT", "WSL_LOGIN_ANSWER_NO_SIGN_IN", "WSL_LOGIN_ANSWER_SIGN_IN", "WSL_LOGIN_UUID_USER", "WSL_LOGIN_VIEW_REQUEST_CODE", "WSL_PAYMENTS_ACTION_PAY_SUBSCRIPTION", "WSL_PAYMENTS_ACTION_SHOW_WALLET", "WSL_PAYMENTS_CONFIG_CASH_OPTION", "", "WSL_PAYMENTS_SUBSCRIPTION_ID", "WSL_PAYMENTS_VIEW_REQUEST_CODE", "WSL_PROFILE_ANSWER_LOG_OUT", "WSL_PROFILE_VIEW_REQUEST_CODE", "login_debug"})
public final class ConstKt {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String URL_BASE = "209.182.219.193:4433/wsl/";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TAG = "WSL-SERVICES";
    public static final int RC_SIGN_IN = 1234;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ID_CASH_WALLET = "CASH_CONST";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String WSL_FLAG_NAME = "FLAG";
    
    /**
     * Login Const
     */
    public static final int WSL_LOGIN_VIEW_REQUEST_CODE = 11111;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String WSL_LOGIN_UUID_USER = "UUID_USER";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String WSL_ACTION_PARAM_NAME = "action_param_name";
    public static final int WSL_LOGIN_ANSWER_NO_SIGN_IN = 12222;
    public static final int WSL_LOGIN_ANSWER_SIGN_IN = 13333;
    public static final int WSL_LOGIN_ACTION_AUTO_LOG_OUT = 15555;
    
    /**
     * Profile Const
     */
    public static final int WSL_PROFILE_VIEW_REQUEST_CODE = 22222;
    public static final int WSL_PROFILE_ANSWER_LOG_OUT = 21111;
    
    /**
     * Payments Const
     */
    public static final int WSL_PAYMENTS_VIEW_REQUEST_CODE = 33333;
    public static final int WSL_PAYMENTS_ACTION_PAY_SUBSCRIPTION = 31111;
    public static final int WSL_PAYMENTS_ACTION_SHOW_WALLET = 32222;
    public static final boolean WSL_PAYMENTS_CONFIG_CASH_OPTION = true;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String WSL_PAYMENTS_SUBSCRIPTION_ID = "subscription_id";
}