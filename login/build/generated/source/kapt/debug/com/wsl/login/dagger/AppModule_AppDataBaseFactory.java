package com.wsl.login.dagger;

import android.content.Context;
import com.wsl.login.database.AppDataBase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_AppDataBaseFactory implements Factory<AppDataBase> {
  private final Provider<Context> contextProvider;

  public AppModule_AppDataBaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public AppDataBase get() {
    return appDataBase(contextProvider.get());
  }

  public static AppModule_AppDataBaseFactory create(Provider<Context> contextProvider) {
    return new AppModule_AppDataBaseFactory(contextProvider);
  }

  public static AppDataBase appDataBase(Context context) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.appDataBase(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
