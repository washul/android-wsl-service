package com.wsl.login.database;

import java.lang.System;

@androidx.room.Database(entities = {com.wsl.login.database.entities.EUser.class, com.wsl.login.database.entities.ECard.class, com.wsl.login.database.entities.ESubscription.class, com.wsl.login.database.entities.EPlan.class, com.wsl.login.database.entities.EConfig.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lcom/wsl/login/database/AppDataBase;", "Landroidx/room/RoomDatabase;", "()V", "daoCard", "Lcom/wsl/login/database/dao/DAOCard;", "daoConfig", "Lcom/wsl/login/database/dao/DAOConfig;", "daoPlan", "Lcom/wsl/login/database/dao/DAOPlan;", "daoSubscription", "Lcom/wsl/login/database/dao/DAOSubscription;", "daoUser", "Lcom/wsl/login/database/dao/DAOUser;", "Companion", "login_debug"})
public abstract class AppDataBase extends androidx.room.RoomDatabase {
    public static final int DATABASE_VERSION = 1;
    private static final java.lang.String DATABASE_NAME = "wsl-services";
    private static com.wsl.login.database.AppDataBase INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.wsl.login.database.AppDataBase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull
    public abstract com.wsl.login.database.dao.DAOUser daoUser();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.wsl.login.database.dao.DAOCard daoCard();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.wsl.login.database.dao.DAOSubscription daoSubscription();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.wsl.login.database.dao.DAOPlan daoPlan();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.wsl.login.database.dao.DAOConfig daoConfig();
    
    public AppDataBase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/wsl/login/database/AppDataBase$Companion;", "", "()V", "DATABASE_NAME", "", "DATABASE_VERSION", "", "INSTANCE", "Lcom/wsl/login/database/AppDataBase;", "getInstance", "context", "Landroid/content/Context;", "login_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable
        public final com.wsl.login.database.AppDataBase getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}