package com.wsl.login.profile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/wsl/login/profile/ProfileActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "progressBarCustom", "Lcom/wsl/login/helpers/WSProgressBarCustom;", "viewModel", "Lcom/wsl/login/profile/view_model/WSProfileViewModel;", "getViewModel", "()Lcom/wsl/login/profile/view_model/WSProfileViewModel;", "setViewModel", "(Lcom/wsl/login/profile/view_model/WSProfileViewModel;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "BuildData", "login_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class ProfileActivity extends androidx.appcompat.app.AppCompatActivity {
    @javax.inject.Inject
    public com.wsl.login.profile.view_model.WSProfileViewModel viewModel;
    private com.wsl.login.helpers.WSProgressBarCustom progressBarCustom;
    
    @org.jetbrains.annotations.NotNull
    public final com.wsl.login.profile.view_model.WSProfileViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.wsl.login.profile.view_model.WSProfileViewModel p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public ProfileActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/wsl/login/profile/ProfileActivity$BuildData;", "Ljava/lang/Thread;", "(Lcom/wsl/login/profile/ProfileActivity;)V", "run", "", "login_debug"})
    public final class BuildData extends java.lang.Thread {
        
        @java.lang.Override
        public void run() {
        }
        
        public BuildData() {
            super();
        }
    }
}