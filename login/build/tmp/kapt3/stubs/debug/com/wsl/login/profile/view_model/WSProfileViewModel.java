package com.wsl.login.profile.view_model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020#2\u0014\u0010C\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010E\u0012\u0004\u0012\u00020F0DJ\"\u0010G\u001a\u00020A2\u001a\u0010C\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011\u0012\u0004\u0012\u00020F0DJ\u0012\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110IJ\"\u0010J\u001a\u00020A2\u001a\u0010C\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0011\u0012\u0004\u0012\u00020F0DJ\u001a\u0010K\u001a\u00020F2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020F0DJ\u001c\u0010M\u001a\u00020A2\u0014\u0010C\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010E\u0012\u0004\u0012\u00020F0DJ\u001c\u0010N\u001a\u00020F2\u0014\u0010C\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010O\u0012\u0004\u0012\u00020F0DJ\u000e\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001070IJ\u001c\u0010Q\u001a\u00020F2\u0014\u0010C\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000107\u0012\u0004\u0012\u00020F0DJ\u0014\u0010R\u001a\u00020A2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\t0\u0011J\u000e\u0010T\u001a\u00020A2\u0006\u0010U\u001a\u00020\u0017J\u000e\u0010V\u001a\u00020A2\u0006\u0010W\u001a\u00020\u001dJ\u000e\u0010X\u001a\u00020F2\u0006\u00106\u001a\u000207J$\u0010Y\u001a\u00020F2\u0006\u00106\u001a\u0002072\u0014\u0010C\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010Z\u0012\u0004\u0012\u00020F0DR0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\"\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R \u0010.\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R&\u00103\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020#8F@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010%\"\u0004\b5\u0010\'R\u001a\u00106\u001a\u000207X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u0002070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0013R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u0002070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0013\u00a8\u0006["}, d2 = {"Lcom/wsl/login/profile/view_model/WSProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "repositoryLogin", "Lcom/wsl/login/login/view_model/RepositoryLogin;", "repositoryPayments", "Lcom/wsl/login/payments/viewmodel/RepositoryPayments;", "(Lcom/wsl/login/login/view_model/RepositoryLogin;Lcom/wsl/login/payments/viewmodel/RepositoryPayments;)V", "value", "Ljava/util/ArrayList;", "Lcom/wsl/login/database/entities/ECard;", "cards", "getCards", "()Ljava/util/ArrayList;", "setCards", "(Ljava/util/ArrayList;)V", "cardsMutable", "Landroidx/lifecycle/MutableLiveData;", "", "getCardsMutable", "()Landroidx/lifecycle/MutableLiveData;", "setCardsMutable", "(Landroidx/lifecycle/MutableLiveData;)V", "currentPlan", "Lcom/wsl/login/database/entities/EPlan;", "getCurrentPlan", "()Lcom/wsl/login/database/entities/EPlan;", "setCurrentPlan", "(Lcom/wsl/login/database/entities/EPlan;)V", "currentSubscription", "Lcom/wsl/login/database/entities/ESubscription;", "getCurrentSubscription", "()Lcom/wsl/login/database/entities/ESubscription;", "setCurrentSubscription", "(Lcom/wsl/login/database/entities/ESubscription;)V", "packageVersion", "", "getPackageVersion", "()Ljava/lang/String;", "setPackageVersion", "(Ljava/lang/String;)V", "planMutable", "getPlanMutable", "setPlanMutable", "subscriptionMutable", "getSubscriptionMutable", "setSubscriptionMutable", "subscriptions", "getSubscriptions", "()Ljava/util/List;", "setSubscriptions", "(Ljava/util/List;)V", "tokenUser", "getTokenUser", "setTokenUser", "user", "Lcom/wsl/login/database/entities/EUser;", "getUser", "()Lcom/wsl/login/database/entities/EUser;", "setUser", "(Lcom/wsl/login/database/entities/EUser;)V", "userMutable", "getUserMutable", "userUpdate", "getUserUpdate", "cancelSubscription", "Lkotlinx/coroutines/Job;", "subscriptionID", "function", "Lkotlin/Function1;", "Lcom/wsl/login/database/entities/SubscriptionResponse;", "", "downloadCards", "getCardsLiveData", "Landroidx/lifecycle/LiveData;", "getLocalSubscriptions", "getLogOut", "", "getSubscription", "getUserCloud", "Lcom/wsl/login/retrofit/LoginResponse;", "getUserLiveData", "getUserLocalAsync", "saveCards", "list", "savePlan", "plan", "saveSubscription", "subscription", "saveUser", "updateUser", "Lcom/wsl/login/retrofit/RegisterResponse;", "login_debug"})
public final class WSProfileViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.Nullable
    private java.lang.String packageVersion;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.wsl.login.database.entities.ECard> cards;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.wsl.login.database.entities.ESubscription> subscriptions;
    @org.jetbrains.annotations.Nullable
    private com.wsl.login.database.entities.ESubscription currentSubscription;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.ESubscription> subscriptionMutable;
    @org.jetbrains.annotations.Nullable
    private com.wsl.login.database.entities.EPlan currentPlan;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.EPlan> planMutable;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.util.List<com.wsl.login.database.entities.ECard>> cardsMutable;
    public com.wsl.login.database.entities.EUser user;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.EUser> userMutable = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.EUser> userUpdate = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String tokenUser = "";
    private final com.wsl.login.login.view_model.RepositoryLogin repositoryLogin = null;
    private final com.wsl.login.payments.viewmodel.RepositoryPayments repositoryPayments = null;
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPackageVersion() {
        return null;
    }
    
    public final void setPackageVersion(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.wsl.login.database.entities.ECard> getCards() {
        return null;
    }
    
    public final void setCards(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.wsl.login.database.entities.ECard> value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.wsl.login.database.entities.ESubscription> getSubscriptions() {
        return null;
    }
    
    public final void setSubscriptions(@org.jetbrains.annotations.NotNull
    java.util.List<com.wsl.login.database.entities.ESubscription> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.wsl.login.database.entities.ESubscription getCurrentSubscription() {
        return null;
    }
    
    public final void setCurrentSubscription(@org.jetbrains.annotations.Nullable
    com.wsl.login.database.entities.ESubscription p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.ESubscription> getSubscriptionMutable() {
        return null;
    }
    
    public final void setSubscriptionMutable(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.ESubscription> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.wsl.login.database.entities.EPlan getCurrentPlan() {
        return null;
    }
    
    public final void setCurrentPlan(@org.jetbrains.annotations.Nullable
    com.wsl.login.database.entities.EPlan p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.EPlan> getPlanMutable() {
        return null;
    }
    
    public final void setPlanMutable(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.EPlan> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.wsl.login.database.entities.ECard>> getCardsMutable() {
        return null;
    }
    
    public final void setCardsMutable(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.util.List<com.wsl.login.database.entities.ECard>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wsl.login.database.entities.EUser getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EUser p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.EUser> getUserMutable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.wsl.login.database.entities.EUser> getUserUpdate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTokenUser() {
        return null;
    }
    
    public final void setTokenUser(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    /**
     * User Methods
     */
    public final void saveUser(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EUser user) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.wsl.login.database.entities.EUser> getUserLiveData() {
        return null;
    }
    
    public final void getUserLocalAsync(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.EUser, kotlin.Unit> function) {
    }
    
    public final void updateUser(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EUser user, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.retrofit.RegisterResponse, kotlin.Unit> function) {
    }
    
    public final void getUserCloud(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.retrofit.LoginResponse, kotlin.Unit> function) {
    }
    
    public final void getLogOut(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> function) {
    }
    
    /**
     * Subscription Methods
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job saveSubscription(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.ESubscription subscription) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getSubscription(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.SubscriptionResponse, kotlin.Unit> function) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getLocalSubscriptions(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.List<com.wsl.login.database.entities.ESubscription>, kotlin.Unit> function) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job cancelSubscription(@org.jetbrains.annotations.NotNull
    java.lang.String subscriptionID, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.SubscriptionResponse, kotlin.Unit> function) {
        return null;
    }
    
    /**
     * Cards Methods
     */
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.wsl.login.database.entities.ECard>> getCardsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job saveCards(@org.jetbrains.annotations.NotNull
    java.util.List<com.wsl.login.database.entities.ECard> list) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job downloadCards(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.List<com.wsl.login.database.entities.ECard>, kotlin.Unit> function) {
        return null;
    }
    
    /**
     * Plan Methods
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job savePlan(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EPlan plan) {
        return null;
    }
    
    @androidx.hilt.lifecycle.ViewModelInject
    public WSProfileViewModel(@org.jetbrains.annotations.NotNull
    com.wsl.login.login.view_model.RepositoryLogin repositoryLogin, @org.jetbrains.annotations.NotNull
    com.wsl.login.payments.viewmodel.RepositoryPayments repositoryPayments) {
        super();
    }
}