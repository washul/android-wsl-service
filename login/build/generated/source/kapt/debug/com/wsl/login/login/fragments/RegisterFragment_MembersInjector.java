package com.wsl.login.login.fragments;

import com.wsl.login.login.view_model.WSLoginViewModel;
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
public final class RegisterFragment_MembersInjector implements MembersInjector<RegisterFragment> {
  private final Provider<WSLoginViewModel> viewModelProvider;

  public RegisterFragment_MembersInjector(Provider<WSLoginViewModel> viewModelProvider) {
    this.viewModelProvider = viewModelProvider;
  }

  public static MembersInjector<RegisterFragment> create(
      Provider<WSLoginViewModel> viewModelProvider) {
    return new RegisterFragment_MembersInjector(viewModelProvider);
  }

  @Override
  public void injectMembers(RegisterFragment instance) {
    injectViewModel(instance, viewModelProvider.get());
  }

  @InjectedFieldSignature("com.wsl.login.login.fragments.RegisterFragment.viewModel")
  public static void injectViewModel(RegisterFragment instance, WSLoginViewModel viewModel) {
    instance.viewModel = viewModel;
  }
}
