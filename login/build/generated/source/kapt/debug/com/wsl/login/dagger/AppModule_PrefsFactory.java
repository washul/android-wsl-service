package com.wsl.login.dagger;

import android.content.Context;
import com.wsl.login.helpers.WSPreferences;
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
public final class AppModule_PrefsFactory implements Factory<WSPreferences> {
  private final Provider<Context> contextProvider;

  public AppModule_PrefsFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public WSPreferences get() {
    return prefs(contextProvider.get());
  }

  public static AppModule_PrefsFactory create(Provider<Context> contextProvider) {
    return new AppModule_PrefsFactory(contextProvider);
  }

  public static WSPreferences prefs(Context context) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.prefs(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
