package com.wsl.login.dagger;

import android.content.Context;
import com.wsl.login.retrofit.RetrofitServices;
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
public final class AppModule_RetrofitServicesFactory implements Factory<RetrofitServices> {
  private final Provider<Context> contextProvider;

  public AppModule_RetrofitServicesFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public RetrofitServices get() {
    return retrofitServices(contextProvider.get());
  }

  public static AppModule_RetrofitServicesFactory create(Provider<Context> contextProvider) {
    return new AppModule_RetrofitServicesFactory(contextProvider);
  }

  public static RetrofitServices retrofitServices(Context context) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.retrofitServices(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
