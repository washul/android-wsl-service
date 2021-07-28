package com.wsl.login.config;

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
public final class Config_Factory implements Factory<Config> {
  private final Provider<Context> contextProvider;

  public Config_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public Config get() {
    return newInstance(contextProvider.get());
  }

  public static Config_Factory create(Provider<Context> contextProvider) {
    return new Config_Factory(contextProvider);
  }

  public static Config newInstance(Context context) {
    return new Config(context);
  }
}
