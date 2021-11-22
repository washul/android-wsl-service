package com.wsl.login.dagger;

import android.content.Context;
import com.wsl.login.payments.viewmodel.WSPaymentViewModel;
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
public final class AppModule_ProvideViewModelPaymentsFactory implements Factory<WSPaymentViewModel> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideViewModelPaymentsFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public WSPaymentViewModel get() {
    return provideViewModelPayments(contextProvider.get());
  }

  public static AppModule_ProvideViewModelPaymentsFactory create(
      Provider<Context> contextProvider) {
    return new AppModule_ProvideViewModelPaymentsFactory(contextProvider);
  }

  public static WSPaymentViewModel provideViewModelPayments(Context context) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.provideViewModelPayments(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
