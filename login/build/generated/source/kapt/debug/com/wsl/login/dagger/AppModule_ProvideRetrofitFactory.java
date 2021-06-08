package com.wsl.login.dagger;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.jetbrains.annotations.Nullable;
import retrofit2.Retrofit;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideRetrofitFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  @Nullable
  public Retrofit get() {
    return provideRetrofit(contextProvider.get());
  }

  public static AppModule_ProvideRetrofitFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideRetrofitFactory(contextProvider);
  }

  @Nullable
  public static Retrofit provideRetrofit(Context context) {
    return AppModule.INSTANCE.provideRetrofit(context);
  }
}
