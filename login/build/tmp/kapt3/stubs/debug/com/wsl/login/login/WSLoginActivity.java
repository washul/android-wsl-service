package com.wsl.login.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010/\u001a\u000200H\u0002J\u0014\u00101\u001a\u0002002\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0002J\b\u00104\u001a\u000200H\u0002J\b\u00105\u001a\u000200H\u0002J\b\u00106\u001a\u000200H\u0002J\"\u00107\u001a\u0002002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\b\u0010;\u001a\u0004\u0018\u00010<H\u0014J\u0012\u0010=\u001a\u0002002\b\u0010>\u001a\u0004\u0018\u00010?H\u0014J\b\u0010@\u001a\u000200H\u0014J\b\u0010A\u001a\u000200H\u0002J\b\u0010B\u001a\u000200H\u0002J\u0014\u0010C\u001a\u0002002\n\b\u0002\u0010D\u001a\u0004\u0018\u00010EH\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010\'\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u0006F"}, d2 = {"Lcom/wsl/login/login/WSLoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "binding", "Lcom/wsl/login/databinding/ActivityLoginBinding;", "getBinding", "()Lcom/wsl/login/databinding/ActivityLoginBinding;", "setBinding", "(Lcom/wsl/login/databinding/ActivityLoginBinding;)V", "callbackManager", "Lcom/facebook/CallbackManager;", "getCallbackManager", "()Lcom/facebook/CallbackManager;", "setCallbackManager", "(Lcom/facebook/CallbackManager;)V", "configClass", "Lcom/wsl/login/config/Config;", "getConfigClass", "()Lcom/wsl/login/config/Config;", "setConfigClass", "(Lcom/wsl/login/config/Config;)V", "gso", "Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "getGso", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "setGso", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;)V", "mGoogleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getMGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "setMGoogleSignInClient", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;)V", "progressBarCustom", "Lcom/wsl/login/helpers/WSProgressBarCustom;", "viewModel", "Lcom/wsl/login/login/view_model/WSLoginViewModel;", "getViewModel", "()Lcom/wsl/login/login/view_model/WSLoginViewModel;", "setViewModel", "(Lcom/wsl/login/login/view_model/WSLoginViewModel;)V", "autoSignIn", "", "dialogNoAccountRegistered", "user", "Lcom/wsl/login/database/entities/EUser;", "loadLoginUI", "localSignIn", "logOut", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setDefaultObservers", "signInWithNetworkAvailable", "userLoggedCorrectly", "userID", "", "login_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class WSLoginActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.wsl.login.databinding.ActivityLoginBinding binding;
    @javax.inject.Inject
    public com.facebook.CallbackManager callbackManager;
    @javax.inject.Inject
    public com.wsl.login.login.view_model.WSLoginViewModel viewModel;
    @javax.inject.Inject
    public com.google.android.gms.auth.api.signin.GoogleSignInOptions gso;
    @javax.inject.Inject
    public com.google.android.gms.auth.api.signin.GoogleSignInClient mGoogleSignInClient;
    @javax.inject.Inject
    public com.google.firebase.auth.FirebaseAuth auth;
    @javax.inject.Inject
    public com.wsl.login.config.Config configClass;
    private com.wsl.login.helpers.WSProgressBarCustom progressBarCustom;
    
    @org.jetbrains.annotations.NotNull
    public final com.wsl.login.databinding.ActivityLoginBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.wsl.login.databinding.ActivityLoginBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.facebook.CallbackManager getCallbackManager() {
        return null;
    }
    
    public final void setCallbackManager(@org.jetbrains.annotations.NotNull
    com.facebook.CallbackManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wsl.login.login.view_model.WSLoginViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.wsl.login.login.view_model.WSLoginViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.auth.api.signin.GoogleSignInOptions getGso() {
        return null;
    }
    
    public final void setGso(@org.jetbrains.annotations.NotNull
    com.google.android.gms.auth.api.signin.GoogleSignInOptions p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.auth.api.signin.GoogleSignInClient getMGoogleSignInClient() {
        return null;
    }
    
    public final void setMGoogleSignInClient(@org.jetbrains.annotations.NotNull
    com.google.android.gms.auth.api.signin.GoogleSignInClient p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.firebase.auth.FirebaseAuth getAuth() {
        return null;
    }
    
    public final void setAuth(@org.jetbrains.annotations.NotNull
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wsl.login.config.Config getConfigClass() {
        return null;
    }
    
    public final void setConfigClass(@org.jetbrains.annotations.NotNull
    com.wsl.login.config.Config p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void loadLoginUI() {
    }
    
    private final void setDefaultObservers() {
    }
    
    private final void autoSignIn() {
    }
    
    private final void signInWithNetworkAvailable() {
    }
    
    @kotlin.Suppress(names = {"LABEL_NAME_CLASH"})
    private final void localSignIn() {
    }
    
    private final void userLoggedCorrectly(java.lang.String userID) {
    }
    
    private final void dialogNoAccountRegistered(com.wsl.login.database.entities.EUser user) {
    }
    
    private final void logOut() {
    }
    
    public WSLoginActivity() {
        super();
    }
}