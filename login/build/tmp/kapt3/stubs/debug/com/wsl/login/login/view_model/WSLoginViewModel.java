package com.wsl.login.login.view_model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010>\u001a\u00020?2\u0014\u0010@\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020?0AJ\u001a\u0010B\u001a\u00020?2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020?0AJ\u000e\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001cJ\u0006\u0010D\u001a\u00020\rJ\u001c\u0010E\u001a\u00020?2\u0014\u0010@\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020?0AJ\u0006\u0010F\u001a\u00020?J$\u0010G\u001a\u00020?2\u0006\u0010H\u001a\u00020\t2\u0014\u0010@\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020?0AJ\u001c\u0010I\u001a\u00020?2\u0014\u0010@\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020?0AJ\u000e\u0010&\u001a\u00020?2\u0006\u0010J\u001a\u00020\u000bJ\u0006\u0010K\u001a\u00020?J\u0006\u0010L\u001a\u00020?J\u0006\u0010M\u001a\u00020?J$\u0010N\u001a\u00020?2\u0006\u0010H\u001a\u00020\t2\u0014\u0010@\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010O\u0012\u0004\u0012\u00020?0AJ\u000e\u0010P\u001a\u00020?2\u0006\u0010H\u001a\u00020\tJ\u0010\u0010Q\u001a\u00020?2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010R\u001a\u00020?J\u000e\u0010S\u001a\u00020?2\u0006\u0010H\u001a\u00020\tJ\u0010\u0010T\u001a\u00020?2\b\u0010H\u001a\u0004\u0018\u00010\tJ\u0010\u0010U\u001a\u00020?2\b\u0010H\u001a\u0004\u0018\u00010\tJ\u0006\u0010V\u001a\u00020?R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\'\u0010\u001eR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\u001c8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010\u001eR\u0019\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR&\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R&\u00106\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R&\u00109\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u00103\"\u0004\b;\u00105R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010%\u00a8\u0006W"}, d2 = {"Lcom/wsl/login/login/view_model/WSLoginViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/wsl/login/login/view_model/RepositoryLogin;", "(Lcom/wsl/login/login/view_model/RepositoryLogin;)V", "_configFile", "Landroidx/lifecycle/MutableLiveData;", "Lcom/wsl/login/database/entities/EConfig;", "_mutableUser", "Lcom/wsl/login/database/entities/EUser;", "_onShowErrorMessage", "", "_onShowProgressDialog", "", "_onUserSignInCorrectly", "_requireRegisterUser", "activityAction", "", "getActivityAction", "()I", "setActivityAction", "(I)V", "commonUser", "getCommonUser", "()Lcom/wsl/login/database/entities/EUser;", "setCommonUser", "(Lcom/wsl/login/database/entities/EUser;)V", "configFile", "Landroidx/lifecycle/LiveData;", "getConfigFile", "()Landroidx/lifecycle/LiveData;", "isTrackingAppOut", "()Z", "setTrackingAppOut", "(Z)V", "mutableUser", "getMutableUser", "()Landroidx/lifecycle/MutableLiveData;", "onShowErrorMessage", "getOnShowErrorMessage", "onShowProgressDialogLiveData", "getOnShowProgressDialogLiveData", "onUserSignInCorrectly", "getOnUserSignInCorrectly", "projectIcon", "getProjectIcon", "requireRegisterUser", "getRequireRegisterUser", "value", "tokenDevice", "getTokenDevice", "()Ljava/lang/String;", "setTokenDevice", "(Ljava/lang/String;)V", "tokenUser", "getTokenUser", "setTokenUser", "userID", "getUserID", "setUserID", "userRegister", "getUserRegister", "getLocalUserAsync", "", "function", "Lkotlin/Function1;", "getLogOut", "getUserLiveData", "isNetworkAvailable", "localSignIn", "logOut", "login", "user", "loginAuto", "message", "onShowErrorMessageDone", "onShowProgressDialog", "onShowProgressDialogDone", "register", "Lcom/wsl/login/retrofit/RegisterResponse;", "saveUserOrUpdate", "setConfigFile", "setOnUserSignInCorrectlyDone", "setUser", "setUserSignInCorrectly", "setUserToRegister", "setUserToRegisterDone", "login_debug"})
public final class WSLoginViewModel extends androidx.lifecycle.ViewModel {
    private boolean isTrackingAppOut = false;
    private androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.EConfig> _configFile;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.wsl.login.database.entities.EConfig> configFile = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.String> projectIcon = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String userID = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String tokenUser = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String tokenDevice = "";
    @org.jetbrains.annotations.NotNull
    private com.wsl.login.database.entities.EUser commonUser;
    private final androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.EUser> _mutableUser = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.EUser> mutableUser = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.EUser> userRegister = null;
    private int activityAction = -1;
    
    /**
     * _onShowProgressDialog ->
     * This methods controlled the progressBar
     */
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _onShowProgressDialog = null;
    
    /**
     * _onShowErrorMessage ->
     * This methods controlled the snack bar
     */
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _onShowErrorMessage = null;
    
    /**
     * _onUserLoginCorrectly ->
     * Notify to the activity that the user is sign in
     */
    private final androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.EUser> _onUserSignInCorrectly = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.wsl.login.database.entities.EUser> onUserSignInCorrectly = null;
    
    /**
     * _requireRegisterUser ->
     * Require a register by a dialog, and request to the activity this dialog
     */
    private final androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.EUser> _requireRegisterUser = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.wsl.login.database.entities.EUser> requireRegisterUser = null;
    private com.wsl.login.login.view_model.RepositoryLogin repository;
    
    public final boolean isTrackingAppOut() {
        return false;
    }
    
    public final void setTrackingAppOut(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.wsl.login.database.entities.EConfig> getConfigFile() {
        return null;
    }
    
    public final void setConfigFile(@org.jetbrains.annotations.Nullable
    com.wsl.login.database.entities.EConfig configFile) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getProjectIcon() {
        return null;
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
    
    @org.jetbrains.annotations.NotNull
    public final com.wsl.login.database.entities.EUser getCommonUser() {
        return null;
    }
    
    public final void setCommonUser(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EUser p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.EUser> getMutableUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EUser user) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.EUser> getUserRegister() {
        return null;
    }
    
    public final boolean isNetworkAvailable() {
        return false;
    }
    
    public final int getActivityAction() {
        return 0;
    }
    
    public final void setActivityAction(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getOnShowProgressDialogLiveData() {
        return null;
    }
    
    public final void onShowProgressDialogDone() {
    }
    
    public final void onShowProgressDialog() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getOnShowErrorMessage() {
        return null;
    }
    
    public final void onShowErrorMessage(@org.jetbrains.annotations.NotNull
    java.lang.String message) {
    }
    
    public final void onShowErrorMessageDone() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.wsl.login.database.entities.EUser> getOnUserSignInCorrectly() {
        return null;
    }
    
    public final void setUserSignInCorrectly(@org.jetbrains.annotations.Nullable
    com.wsl.login.database.entities.EUser user) {
    }
    
    public final void setOnUserSignInCorrectlyDone() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.wsl.login.database.entities.EUser> getRequireRegisterUser() {
        return null;
    }
    
    public final void setUserToRegister(@org.jetbrains.annotations.Nullable
    com.wsl.login.database.entities.EUser user) {
    }
    
    public final void setUserToRegisterDone() {
    }
    
    public final void localSignIn(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.EUser, kotlin.Unit> function) {
    }
    
    public final void saveUserOrUpdate(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EUser user) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.wsl.login.database.entities.EUser> getUserLiveData() {
        return null;
    }
    
    public final void getLocalUserAsync(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.EUser, kotlin.Unit> function) {
    }
    
    public final void login(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EUser user, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.EUser, kotlin.Unit> function) {
    }
    
    public final void loginAuto(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> function) {
    }
    
    public final void getLogOut(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> function) {
    }
    
    public final void register(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EUser user, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.retrofit.RegisterResponse, kotlin.Unit> function) {
    }
    
    public final void logOut() {
    }
    
    @androidx.hilt.lifecycle.ViewModelInject
    public WSLoginViewModel(@org.jetbrains.annotations.NotNull
    com.wsl.login.login.view_model.RepositoryLogin repository) {
        super();
    }
}