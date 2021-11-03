package com.wsl.login.payments.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0014\u0010-\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010/\u0012\u0004\u0012\u0002000.J\u001a\u00101\u001a\u00020*2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002000.J\"\u00103\u001a\u00020*2\u001a\u0010-\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013\u0012\u0004\u0012\u0002000.J,\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020,2\u0014\u0010-\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010/\u0012\u0004\u0012\u0002000.J\u001c\u0010\u001f\u001a\u00020*2\u0014\u0010-\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000107\u0012\u0004\u0012\u0002000.J\u001c\u00108\u001a\u00020*2\u0014\u0010-\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010/\u0012\u0004\u0012\u0002000.J\u000e\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0:J2\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020,2\u001a\u0010-\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013\u0012\u0004\u0012\u0002000.J$\u0010?\u001a\u00020*2\u0006\u00105\u001a\u00020,2\u0014\u0010-\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010@\u0012\u0004\u0012\u0002000.J\u0014\u0010A\u001a\u0002002\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\r0\u0013J\u000e\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020ER \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR0\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR&\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR0\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00132\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00190\u0013@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R&\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010\u0004\u00a8\u0006F"}, d2 = {"Lcom/wsl/login/payments/viewmodel/WSPaymentViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/wsl/login/payments/viewmodel/RepositoryPayments;", "(Lcom/wsl/login/payments/viewmodel/RepositoryPayments;)V", "activityActions", "Ljava/util/ArrayList;", "", "getActivityActions", "()Ljava/util/ArrayList;", "setActivityActions", "(Ljava/util/ArrayList;)V", "value", "Lcom/wsl/login/database/entities/ECard;", "cards", "getCards", "setCards", "cardsMutable", "Landroidx/lifecycle/MutableLiveData;", "", "getCardsMutable", "()Landroidx/lifecycle/MutableLiveData;", "setCardsMutable", "(Landroidx/lifecycle/MutableLiveData;)V", "currentPlan", "Lcom/wsl/login/database/entities/EPlan;", "getCurrentPlan", "()Lcom/wsl/login/database/entities/EPlan;", "setCurrentPlan", "(Lcom/wsl/login/database/entities/EPlan;)V", "planList", "getPlanList", "()Ljava/util/List;", "setPlanList", "(Ljava/util/List;)V", "planListMutable", "getPlanListMutable", "setPlanListMutable", "getRepository", "()Lcom/wsl/login/payments/viewmodel/RepositoryPayments;", "setRepository", "cancelPayment", "Lkotlinx/coroutines/Job;", "subscriptionID", "", "function", "Lkotlin/Function1;", "Lcom/wsl/login/database/entities/SubscriptionResponse;", "", "createOpenPayCustomer", "", "downloadCards", "generateSubscription", "card_id", "plan_id", "Lcom/wsl/login/database/entities/PlanResponse;", "getSubscription", "getUserLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/wsl/login/database/entities/EUser;", "registerCard", "device_session_id", "token_id", "removeCard", "Lcom/wsl/login/database/entities/CardsResponse;", "saveCards", "list", "saveSubscription", "subscription", "Lcom/wsl/login/database/entities/ESubscription;", "login_debug"})
public final class WSPaymentViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.wsl.login.database.entities.ECard> cards;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.util.List<com.wsl.login.database.entities.ECard>> cardsMutable;
    @org.jetbrains.annotations.Nullable
    private com.wsl.login.database.entities.EPlan currentPlan;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.wsl.login.database.entities.EPlan> planList;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.util.List<com.wsl.login.database.entities.EPlan>> planListMutable;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<java.lang.Integer> activityActions;
    @org.jetbrains.annotations.NotNull
    private com.wsl.login.payments.viewmodel.RepositoryPayments repository;
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.wsl.login.database.entities.ECard> getCards() {
        return null;
    }
    
    public final void setCards(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.wsl.login.database.entities.ECard> value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.wsl.login.database.entities.ECard>> getCardsMutable() {
        return null;
    }
    
    public final void setCardsMutable(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.util.List<com.wsl.login.database.entities.ECard>> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.wsl.login.database.entities.EPlan getCurrentPlan() {
        return null;
    }
    
    public final void setCurrentPlan(@org.jetbrains.annotations.Nullable
    com.wsl.login.database.entities.EPlan p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.wsl.login.database.entities.EPlan> getPlanList() {
        return null;
    }
    
    public final void setPlanList(@org.jetbrains.annotations.NotNull
    java.util.List<com.wsl.login.database.entities.EPlan> value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.wsl.login.database.entities.EPlan>> getPlanListMutable() {
        return null;
    }
    
    public final void setPlanListMutable(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.util.List<com.wsl.login.database.entities.EPlan>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.Integer> getActivityActions() {
        return null;
    }
    
    public final void setActivityActions(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.Integer> p0) {
    }
    
    /**
     * User methods
     */
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.wsl.login.database.entities.EUser> getUserLiveData() {
        return null;
    }
    
    /**
     * Cards
     */
    public final void saveCards(@org.jetbrains.annotations.NotNull
    java.util.List<com.wsl.login.database.entities.ECard> list) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job registerCard(@org.jetbrains.annotations.NotNull
    java.lang.String device_session_id, @org.jetbrains.annotations.NotNull
    java.lang.String token_id, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.List<com.wsl.login.database.entities.ECard>, kotlin.Unit> function) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job downloadCards(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.List<com.wsl.login.database.entities.ECard>, kotlin.Unit> function) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job createOpenPayCustomer(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> function) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job removeCard(@org.jetbrains.annotations.NotNull
    java.lang.String card_id, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.CardsResponse, kotlin.Unit> function) {
        return null;
    }
    
    /**
     * Plans
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getPlanList(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.PlanResponse, kotlin.Unit> function) {
        return null;
    }
    
    /**
     * Subscriptions
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job generateSubscription(@org.jetbrains.annotations.NotNull
    java.lang.String card_id, @org.jetbrains.annotations.NotNull
    java.lang.String plan_id, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.SubscriptionResponse, kotlin.Unit> function) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getSubscription(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.SubscriptionResponse, kotlin.Unit> function) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job cancelPayment(@org.jetbrains.annotations.NotNull
    java.lang.String subscriptionID, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.SubscriptionResponse, kotlin.Unit> function) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job saveSubscription(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.ESubscription subscription) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wsl.login.payments.viewmodel.RepositoryPayments getRepository() {
        return null;
    }
    
    public final void setRepository(@org.jetbrains.annotations.NotNull
    com.wsl.login.payments.viewmodel.RepositoryPayments p0) {
    }
    
    @androidx.hilt.lifecycle.ViewModelInject
    public WSPaymentViewModel(@org.jetbrains.annotations.NotNull
    com.wsl.login.payments.viewmodel.RepositoryPayments repository) {
        super();
    }
}