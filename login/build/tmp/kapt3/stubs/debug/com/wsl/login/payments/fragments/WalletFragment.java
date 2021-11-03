package com.wsl.login.payments.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0004!\"#$B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J,\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000e0\u001fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006%"}, d2 = {"Lcom/wsl/login/payments/fragments/WalletFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "UI", "Landroid/view/View;", "progressBarCustom", "Lcom/wsl/login/helpers/WSProgressBarCustom;", "viewModel", "Lcom/wsl/login/payments/viewmodel/WSPaymentViewModel;", "getViewModel", "()Lcom/wsl/login/payments/viewmodel/WSPaymentViewModel;", "setViewModel", "(Lcom/wsl/login/payments/viewmodel/WSPaymentViewModel;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onStart", "optionalMessage", "title", "", "message", "function", "Lkotlin/Function1;", "", "AdapterWalletCards", "BuildData", "BuildUI", "Companion", "login_debug"})
public final class WalletFragment extends androidx.fragment.app.DialogFragment {
    public com.wsl.login.payments.viewmodel.WSPaymentViewModel viewModel;
    private com.wsl.login.helpers.WSProgressBarCustom progressBarCustom;
    private android.view.View UI;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TAG = "WalletFragment";
    @org.jetbrains.annotations.NotNull
    public static final com.wsl.login.payments.fragments.WalletFragment.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.wsl.login.payments.viewmodel.WSPaymentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.wsl.login.payments.viewmodel.WSPaymentViewModel p0) {
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void optionalMessage(java.lang.String title, java.lang.String message, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> function) {
    }
    
    @java.lang.Override
    public void onDismiss(@org.jetbrains.annotations.NotNull
    android.content.DialogInterface dialog) {
    }
    
    public WalletFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/wsl/login/payments/fragments/WalletFragment$BuildData;", "Ljava/lang/Thread;", "(Lcom/wsl/login/payments/fragments/WalletFragment;)V", "createOpenPayAccount", "", "getCloudCards", "run", "login_debug"})
    public final class BuildData extends java.lang.Thread {
        
        @java.lang.Override
        public void run() {
        }
        
        private final void getCloudCards() {
        }
        
        private final void createOpenPayAccount() {
        }
        
        public BuildData() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0016J\f\u0010\u0010\u001a\u00020\b*\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/wsl/login/payments/fragments/WalletFragment$BuildUI;", "Ljava/lang/Thread;", "(Lcom/wsl/login/payments/fragments/WalletFragment;)V", "adapter", "Lcom/wsl/login/payments/fragments/WalletFragment$AdapterWalletCards;", "addPaymentMethod", "Landroidx/cardview/widget/CardView;", "buildRecycler", "", "createSubscription", "card", "Lcom/wsl/login/database/entities/ECard;", "removeCard", "position", "", "run", "initSwipe", "Landroidx/recyclerview/widget/RecyclerView;", "login_debug"})
    public final class BuildUI extends java.lang.Thread {
        private com.wsl.login.payments.fragments.WalletFragment.AdapterWalletCards adapter;
        private final androidx.cardview.widget.CardView addPaymentMethod = null;
        
        @java.lang.Override
        public void run() {
        }
        
        private final void createSubscription(com.wsl.login.database.entities.ECard card) {
        }
        
        private final void initSwipe(androidx.recyclerview.widget.RecyclerView $this$initSwipe) {
        }
        
        private final void removeCard(int position) {
        }
        
        private final void buildRecycler() {
        }
        
        public BuildUI() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\n2\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000fH\u0017J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/wsl/login/payments/fragments/WalletFragment$AdapterWalletCards;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/wsl/login/payments/fragments/WalletFragment$AdapterWalletCards$ViewHolder;", "context", "Landroid/content/Context;", "cards", "", "Lcom/wsl/login/database/entities/ECard;", "function", "Lkotlin/Function1;", "", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "addItem", "newItems", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeItem", "ViewHolder", "login_debug"})
    public static final class AdapterWalletCards extends androidx.recyclerview.widget.RecyclerView.Adapter<com.wsl.login.payments.fragments.WalletFragment.AdapterWalletCards.ViewHolder> {
        private final android.content.Context context = null;
        private java.util.List<com.wsl.login.database.entities.ECard> cards;
        private final kotlin.jvm.functions.Function1<com.wsl.login.database.entities.ECard, kotlin.Unit> function = null;
        
        @android.annotation.SuppressLint(value = {"SetTextI18n"})
        @java.lang.Override
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull
        com.wsl.login.payments.fragments.WalletFragment.AdapterWalletCards.ViewHolder holder, int position) {
        }
        
        public final void addItem(@org.jetbrains.annotations.NotNull
        java.util.List<com.wsl.login.database.entities.ECard> newItems) {
        }
        
        public final void removeItem(int position) {
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.wsl.login.payments.fragments.WalletFragment.AdapterWalletCards.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override
        public int getItemCount() {
            return 0;
        }
        
        public AdapterWalletCards(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.util.List<com.wsl.login.database.entities.ECard> cards, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.ECard, kotlin.Unit> function) {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/wsl/login/payments/fragments/WalletFragment$AdapterWalletCards$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/wsl/login/payments/fragments/WalletFragment$AdapterWalletCards;Landroid/view/View;)V", "title", "Lcom/google/android/material/textview/MaterialTextView;", "kotlin.jvm.PlatformType", "getTitle", "()Lcom/google/android/material/textview/MaterialTextView;", "login_debug"})
        public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            private final com.google.android.material.textview.MaterialTextView title = null;
            
            public final com.google.android.material.textview.MaterialTextView getTitle() {
                return null;
            }
            
            public ViewHolder(@org.jetbrains.annotations.NotNull
            android.view.View view) {
                super(null);
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/wsl/login/payments/fragments/WalletFragment$Companion;", "", "()V", "TAG", "", "login_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}