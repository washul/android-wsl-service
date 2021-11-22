package com.wsl.login.login.view_model;

import com.wsl.login.database.AppDataBase;
import com.wsl.login.helpers.WSPreferences;
import com.wsl.login.retrofit.RetrofitServices;
import dagger.internal.Factory;
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
public final class RepositoryLogin_Factory implements Factory<RepositoryLogin> {
  private final Provider<AppDataBase> dbProvider;

  private final Provider<WSPreferences> prefsProvider;

  private final Provider<RetrofitServices> serviceProvider;

  public RepositoryLogin_Factory(Provider<AppDataBase> dbProvider,
      Provider<WSPreferences> prefsProvider, Provider<RetrofitServices> serviceProvider) {
    this.dbProvider = dbProvider;
    this.prefsProvider = prefsProvider;
    this.serviceProvider = serviceProvider;
  }

  @Override
  public RepositoryLogin get() {
    return newInstance(dbProvider.get(), prefsProvider.get(), serviceProvider.get());
  }

  public static RepositoryLogin_Factory create(Provider<AppDataBase> dbProvider,
      Provider<WSPreferences> prefsProvider, Provider<RetrofitServices> serviceProvider) {
    return new RepositoryLogin_Factory(dbProvider, prefsProvider, serviceProvider);
  }

  public static RepositoryLogin newInstance(AppDataBase db, WSPreferences prefs,
      RetrofitServices service) {
    return new RepositoryLogin(db, prefs, service);
  }
}
