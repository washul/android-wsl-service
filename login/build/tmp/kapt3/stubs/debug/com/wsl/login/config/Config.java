package com.wsl.login.config;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/wsl/login/config/Config;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fileOutputStream", "Ljava/io/FileOutputStream;", "readConfigFile", "Lcom/wsl/login/database/entities/EConfig;", "saveConfigFile", "", "configFile", "", "login_debug"})
public final class Config {
    private java.io.FileOutputStream fileOutputStream;
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.Nullable
    public final com.wsl.login.database.entities.EConfig readConfigFile() {
        return null;
    }
    
    public final void saveConfigFile(@org.jetbrains.annotations.NotNull
    java.lang.String configFile) {
    }
    
    @javax.inject.Inject
    public Config(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
}