package com.wsl.login.helpers;

import android.content.Context;
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
public final class WSPreferences_Factory implements Factory<WSPreferences> {
  private final Provider<Context> contextProvider;

  public WSPreferences_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public WSPreferences get() {
    return newInstance(contextProvider.get());
  }

  public static WSPreferences_Factory create(Provider<Context> contextProvider) {
    return new WSPreferences_Factory(contextProvider);
  }

  public static WSPreferences newInstance(Context context) {
    return new WSPreferences(context);
  }
}
