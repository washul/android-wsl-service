package com.wsl.login.database.dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\b\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\'J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\'J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000bH\'J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\'\u00a8\u0006\u000f"}, d2 = {"Lcom/wsl/login/database/dao/DAOUser;", "", "deleteUsers", "", "getUser", "Lcom/wsl/login/database/entities/EUser;", "getUserLiveData", "Landroidx/lifecycle/LiveData;", "insertUser", "user", "isUserExist", "", "email", "signIn", "update", "login_debug"})
public abstract interface DAOUser {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertUser(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EUser user);
    
    @androidx.room.Update
    public abstract void update(@org.jetbrains.annotations.NotNull
    com.wsl.login.database.entities.EUser user);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM User ")
    public abstract com.wsl.login.database.entities.EUser signIn();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT uuid_user FROM User WHERE email == :email")
    public abstract java.lang.String isUserExist(@org.jetbrains.annotations.NotNull
    java.lang.String email);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM User ")
    public abstract com.wsl.login.database.entities.EUser getUser();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM User ")
    public abstract androidx.lifecycle.LiveData<com.wsl.login.database.entities.EUser> getUserLiveData();
    
    @androidx.room.Query(value = "DELETE FROM User ")
    public abstract void deleteUsers();
}