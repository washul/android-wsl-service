package com.wsl.login.dagger;

import android.content.Context;
import com.wsl.login.config.Config;
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
public final class AppModule_ProvideConfigClassFactory implements Factory<Config> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideConfigClassFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public Config get() {
    return provideConfigClass(contextProvider.get());
  }

  public static AppModule_ProvideConfigClassFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideConfigClassFactory(contextProvider);
  }

  public static Config provideConfigClass(Context context) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.provideConfigClass(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
