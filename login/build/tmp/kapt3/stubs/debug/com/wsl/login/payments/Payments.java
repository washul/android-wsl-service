package com.wsl.login.payments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u00a2\u0006\u0002\b\u0018J\u0006\u0010\u0019\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u001c"}, d2 = {"Lcom/wsl/login/payments/Payments;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "progressBarCustom", "Lcom/wsl/login/helpers/WSProgressBarCustom;", "viewModel", "Lcom/wsl/login/payments/viewmodel/WSPaymentViewModel;", "getViewModel", "()Lcom/wsl/login/payments/viewmodel/WSPaymentViewModel;", "setViewModel", "(Lcom/wsl/login/payments/viewmodel/WSPaymentViewModel;)V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "paidCorrectly", "subscriptionID", "", "paidCorrectly$login_debug", "walletDialog", "BuildData", "BuildUI", "login_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class Payments extends androidx.appcompat.app.AppCompatActivity {
    @javax.inject.Inject
    public com.wsl.login.payments.viewmodel.WSPaymentViewModel viewModel;
    private com.wsl.login.helpers.WSProgressBarCustom progressBarCustom;
    
    @org.jetbrains.annotations.NotNull
    public final com.wsl.login.payments.viewmodel.WSPaymentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.wsl.login.payments.viewmodel.WSPaymentViewModel p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public final void paidCorrectly$login_debug(@org.jetbrains.annotations.NotNull
    java.lang.String subscriptionID) {
    }
    
    public final void walletDialog() {
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    public Payments() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/wsl/login/payments/Payments$BuildData;", "Ljava/lang/Thread;", "(Lcom/wsl/login/payments/Payments;)V", "run", "", "login_debug"})
    public final class BuildData extends java.lang.Thread {
        
        @java.lang.Override
        public void run() {
        }
        
        public BuildData() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\u0003\u001a\n0\u0004R\u00060\u0000R\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/wsl/login/payments/Payments$BuildUI;", "Ljava/lang/Thread;", "(Lcom/wsl/login/payments/Payments;)V", "adapter", "Lcom/wsl/login/payments/Payments$BuildUI$AdapterPlan;", "Lcom/wsl/login/payments/Payments;", "buildRecycler", "", "run", "AdapterPlan", "login_debug"})
    public final class BuildUI extends java.lang.Thread {
        private com.wsl.login.payments.Payments.BuildUI.AdapterPlan adapter;
        
        @java.lang.Override
        public void run() {
        }
        
        private final void buildRecycler() {
        }
        
        public BuildUI() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0014\u0012\u0010\u0012\u000e0\u0002R\n0\u0000R\u00060\u0003R\u00020\u00040\u0001:\u0001\u001aB!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\n2\u0012\u0010\u0014\u001a\u000e0\u0002R\n0\u0000R\u00060\u0003R\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0012H\u0017J$\u0010\u0016\u001a\u000e0\u0002R\n0\u0000R\u00060\u0003R\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/wsl/login/payments/Payments$BuildUI$AdapterPlan;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/wsl/login/payments/Payments$BuildUI$AdapterPlan$ViewHolder;", "Lcom/wsl/login/payments/Payments$BuildUI;", "Lcom/wsl/login/payments/Payments;", "context", "Landroid/content/Context;", "function", "Lkotlin/Function1;", "Lcom/wsl/login/database/entities/EPlan;", "", "(Lcom/wsl/login/payments/Payments$BuildUI;Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "itemList", "Ljava/util/ArrayList;", "addItem", "newItems", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "login_debug"})
        public final class AdapterPlan extends androidx.recyclerview.widget.RecyclerView.Adapter<com.wsl.login.payments.Payments.BuildUI.AdapterPlan.ViewHolder> {
            private java.util.ArrayList<com.wsl.login.database.entities.EPlan> itemList;
            private final android.content.Context context = null;
            private final kotlin.jvm.functions.Function1<com.wsl.login.database.entities.EPlan, kotlin.Unit> function = null;
            
            @android.annotation.SuppressLint(value = {"SetTextI18n"})
            @java.lang.Override
            public void onBindViewHolder(@org.jetbrains.annotations.NotNull
            com.wsl.login.payments.Payments.BuildUI.AdapterPlan.ViewHolder holder, int position) {
            }
            
            public final void addItem(@org.jetbrains.annotations.NotNull
            java.util.List<com.wsl.login.database.entities.EPlan> newItems) {
            }
            
            @org.jetbrains.annotations.NotNull
            @java.lang.Override
            public com.wsl.login.payments.Payments.BuildUI.AdapterPlan.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
            android.view.ViewGroup parent, int viewType) {
                return null;
            }
            
            @java.lang.Override
            public int getItemCount() {
                return 0;
            }
            
            public AdapterPlan(@org.jetbrains.annotations.NotNull
            android.content.Context context, @org.jetbrains.annotations.NotNull
            kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.EPlan, kotlin.Unit> function) {
                super();
            }
            
            @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/wsl/login/payments/Payments$BuildUI$AdapterPlan$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/wsl/login/payments/Payments$BuildUI$AdapterPlan;Landroid/view/View;)V", "amount_", "Lcom/google/android/material/textview/MaterialTextView;", "kotlin.jvm.PlatformType", "getAmount_", "()Lcom/google/android/material/textview/MaterialTextView;", "name", "getName", "repeat_Every_", "getRepeat_Every_", "trial_days_", "getTrial_days_", "login_debug"})
            public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
                private final com.google.android.material.textview.MaterialTextView name = null;
                private final com.google.android.material.textview.MaterialTextView repeat_Every_ = null;
                private final com.google.android.material.textview.MaterialTextView trial_days_ = null;
                private final com.google.android.material.textview.MaterialTextView amount_ = null;
                
                public final com.google.android.material.textview.MaterialTextView getName() {
                    return null;
                }
                
                public final com.google.android.material.textview.MaterialTextView getRepeat_Every_() {
                    return null;
                }
                
                public final com.google.android.material.textview.MaterialTextView getTrial_days_() {
                    return null;
                }
                
                public final com.google.android.material.textview.MaterialTextView getAmount_() {
                    return null;
                }
                
                public ViewHolder(@org.jetbrains.annotations.NotNull
                android.view.View view) {
                    super(null);
                }
            }
        }
    }
}