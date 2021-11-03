package com.wsl.login.payments.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J/\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J%\u0010\u0017\u001a\u00020\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J-\u0010\u001a\u001a\u00020\u00102\u001a\u0010\u0013\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J7\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J-\u0010!\u001a\u00020\u00102\u001a\u0010\u0013\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0#J-\u0010$\u001a\u00020\u00102\u001a\u0010\u0013\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\'0#J\'\u0010(\u001a\u00020\u00102\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\'\u0010*\u001a\u00020\u00102\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J=\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\u001a\u0010\u0013\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J/\u0010.\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010/\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001f\u00100\u001a\u00020\u00102\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J\u0019\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u000205H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00106J\u0019\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020%H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00109R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006:"}, d2 = {"Lcom/wsl/login/payments/viewmodel/RepositoryPayments;", "", "db", "Lcom/wsl/login/database/AppDataBase;", "service", "Lcom/wsl/login/retrofit/RetrofitServices;", "(Lcom/wsl/login/database/AppDataBase;Lcom/wsl/login/retrofit/RetrofitServices;)V", "daoCard", "Lcom/wsl/login/database/dao/DAOCard;", "daoPlan", "Lcom/wsl/login/database/dao/DAOPlan;", "daoSubscription", "Lcom/wsl/login/database/dao/DAOSubscription;", "daoUser", "Lcom/wsl/login/database/dao/DAOUser;", "cancelSubscription", "", "subscriptionID", "", "function", "Lkotlin/Function1;", "Lcom/wsl/login/database/entities/SubscriptionResponse;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createOpenPayCustomer", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadCards", "", "Lcom/wsl/login/database/entities/ECard;", "generateSubscription", "card_id", "plan_id", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCards", "getCardsLiveData", "Landroidx/lifecycle/LiveData;", "getLocalSubscription", "Lcom/wsl/login/database/entities/ESubscription;", "getLocalUserLiveData", "Lcom/wsl/login/database/entities/EUser;", "getPlanList", "Lcom/wsl/login/database/entities/PlanResponse;", "getSubscription", "registerCard", "device_session_id", "token_id", "removeCards", "Lcom/wsl/login/database/entities/CardsResponse;", "saveCardList", "list", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePlan", "plan", "Lcom/wsl/login/database/entities/EPlan;", "(Lcom/wsl/login/database/entities/EPlan;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSubscription", "subscription", "(Lcom/wsl/login/database/entities/ESubscription;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login_debug"})
public final class RepositoryPayments {
    private com.wsl.login.database.dao.DAOUser daoUser;
    private com.wsl.login.database.dao.DAOCard daoCard;
    private com.wsl.login.database.dao.DAOSubscription daoSubscription;
    private com.wsl.login.database.dao.DAOPlan daoPlan;
    private com.wsl.login.retrofit.RetrofitServices service;
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object generateSubscription(@org.jetbrains.annotations.NotNull
    java.lang.String card_id, @org.jetbrains.annotations.NotNull
    java.lang.String plan_id, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.SubscriptionResponse, kotlin.Unit> function, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getPlanList(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.PlanResponse, kotlin.Unit> function, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getSubscription(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.SubscriptionResponse, kotlin.Unit> function, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    /**
     * Subscription Methods
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object cancelSubscription(@org.jetbrains.annotations.NotNull
    java.lang.String subscriptionID, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.SubscriptionResponse, kotlin.Unit> function, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveSubscription(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.ESubscription subscription, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLocalSubscription(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.List<com.wsl.login.database.entities.ESubscription>, kotlin.Unit> function, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    /**
     * User Methods
     */
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.wsl.login.database.entities.EUser> getLocalUserLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object createOpenPayCustomer(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> function, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    /**
     * Cards Methods
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object downloadCards(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.List<com.wsl.login.database.entities.ECard>, kotlin.Unit> function, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object registerCard(@org.jetbrains.annotations.NotNull
    java.lang.String device_session_id, @org.jetbrains.annotations.NotNull
    java.lang.String token_id, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.List<com.wsl.login.database.entities.ECard>, kotlin.Unit> function, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.wsl.login.database.entities.ECard>> getCardsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getCards(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.List<com.wsl.login.database.entities.ECard>, kotlin.Unit> function, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveCardList(@org.jetbrains.annotations.NotNull
    java.util.List<com.wsl.login.database.entities.ECard> list, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object removeCards(@org.jetbrains.annotations.NotNull
    java.lang.String card_id, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.wsl.login.database.entities.CardsResponse, kotlin.Unit> function, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
        return null;
    }
    
    /**
     * Plan Methods
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object savePlan(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EPlan plan, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public RepositoryPayments(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.AppDataBase db, @org.jetbrains.annotations.NotNull
    com.wsl.login.retrofit.RetrofitServices service) {
        super();
    }
}