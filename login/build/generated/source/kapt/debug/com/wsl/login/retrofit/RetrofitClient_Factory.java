package com.wsl.login.retrofit;

import com.wsl.login.helpers.WSPreferences;
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
public final class RetrofitClient_Factory implements Factory<RetrofitClient> {
  private final Provider<WSPreferences> prefsProvider;

  public RetrofitClient_Factory(Provider<WSPreferences> prefsProvider) {
    this.prefsProvider = prefsProvider;
  }

  @Override
  public RetrofitClient get() {
    return newInstance(prefsProvider.get());
  }

  public static RetrofitClient_Factory create(Provider<WSPreferences> prefsProvider) {
    return new RetrofitClient_Factory(prefsProvider);
  }

  public static RetrofitClient newInstance(WSPreferences prefs) {
    return new RetrofitClient(prefs);
  }
}
