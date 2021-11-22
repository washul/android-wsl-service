package com.wsl.login.payments;

import com.wsl.login.payments.viewmodel.WSPaymentViewModel;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class Payments_MembersInjector implements MembersInjector<Payments> {
  private final Provider<WSPaymentViewModel> viewModelProvider;

  public Payments_MembersInjector(Provider<WSPaymentViewModel> viewModelProvider) {
    this.viewModelProvider = viewModelProvider;
  }

  public static MembersInjector<Payments> create(Provider<WSPaymentViewModel> viewModelProvider) {
    return new Payments_MembersInjector(viewModelProvider);
  }

  @Override
  public void injectMembers(Payments instance) {
    injectViewModel(instance, viewModelProvider.get());
  }

  @InjectedFieldSignature("com.wsl.login.payments.Payments.viewModel")
  public static void injectViewModel(Payments instance, WSPaymentViewModel viewModel) {
    instance.viewModel = viewModel;
  }
}
