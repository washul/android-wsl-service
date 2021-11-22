package com.wsl.login.dagger;

import android.content.Context;
import com.wsl.login.login.view_model.WSLoginViewModel;
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
public final class AppModule_ProvideViewModelLoginFactory implements Factory<WSLoginViewModel> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideViewModelLoginFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public WSLoginViewModel get() {
    return provideViewModelLogin(contextProvider.get());
  }

  public static AppModule_ProvideViewModelLoginFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideViewModelLoginFactory(contextProvider);
  }

  public static WSLoginViewModel provideViewModelLogin(Context context) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.provideViewModelLogin(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
