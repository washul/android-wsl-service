package com.wsl.login.dagger;

import com.facebook.CallbackManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_CallbackManagerFactory implements Factory<CallbackManager> {
  @Override
  public CallbackManager get() {
    return callbackManager();
  }

  public static AppModule_CallbackManagerFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CallbackManager callbackManager() {
    return Preconditions.checkNotNull(AppModule.INSTANCE.callbackManager(), "Cannot return null from a non-@Nullable @Provides method");
  }

  private static final class InstanceHolder {
    private static final AppModule_CallbackManagerFactory INSTANCE = new AppModule_CallbackManagerFactory();
  }
}
