package com.wsl.login.database.dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006H\'J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'\u00a8\u0006\n"}, d2 = {"Lcom/wsl/login/database/dao/DAOCard;", "", "getCards", "", "Lcom/wsl/login/database/entities/ECard;", "getCardsLiveData", "Landroidx/lifecycle/LiveData;", "saveCardList", "", "list", "login_debug"})
public abstract interface DAOCard {
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM card")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.wsl.login.database.entities.ECard>> getCardsLiveData();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM card")
    public abstract java.util.List<com.wsl.login.database.entities.ECard> getCards();
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void saveCardList(@org.jetbrains.annotations.NotNull
    java.util.List<com.wsl.login.database.entities.ECard> list);
}