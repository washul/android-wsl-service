package com.wsl.login.login.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/wsl/login/login/fragments/RegisterFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/wsl/login/databinding/FragmentRegisterBinding;", "viewModel", "Lcom/wsl/login/login/view_model/WSLoginViewModel;", "getViewModel", "()Lcom/wsl/login/login/view_model/WSLoginViewModel;", "setViewModel", "(Lcom/wsl/login/login/view_model/WSLoginViewModel;)V", "initRegisterButton", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setDefaultObservers", "validateAllFields", "", "Companion", "login_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class RegisterFragment extends androidx.fragment.app.Fragment {
    @javax.inject.Inject
    public com.wsl.login.login.view_model.WSLoginViewModel viewModel;
    private com.wsl.login.databinding.FragmentRegisterBinding binding;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TAG = "RegisterFragment";
    @org.jetbrains.annotations.NotNull
    public static final com.wsl.login.login.fragments.RegisterFragment.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.wsl.login.login.view_model.WSLoginViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.wsl.login.login.view_model.WSLoginViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setDefaultObservers() {
    }
    
    private final void initRegisterButton() {
    }
    
    private final boolean validateAllFields() {
        return false;
    }
    
    public RegisterFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/wsl/login/login/fragments/RegisterFragment$Companion;", "", "()V", "TAG", "", "login_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}