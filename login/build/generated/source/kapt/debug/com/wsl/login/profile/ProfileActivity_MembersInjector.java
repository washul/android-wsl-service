package com.wsl.login.profile;

import com.wsl.login.profile.view_model.WSProfileViewModel;
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
public final class ProfileActivity_MembersInjector implements MembersInjector<ProfileActivity> {
  private final Provider<WSProfileViewModel> viewModelProvider;

  public ProfileActivity_MembersInjector(Provider<WSProfileViewModel> viewModelProvider) {
    this.viewModelProvider = viewModelProvider;
  }

  public static MembersInjector<ProfileActivity> create(
      Provider<WSProfileViewModel> viewModelProvider) {
    return new ProfileActivity_MembersInjector(viewModelProvider);
  }

  @Override
  public void injectMembers(ProfileActivity instance) {
    injectViewModel(instance, viewModelProvider.get());
  }

  @InjectedFieldSignature("com.wsl.login.profile.ProfileActivity.viewModel")
  public static void injectViewModel(ProfileActivity instance, WSProfileViewModel viewModel) {
    instance.viewModel = viewModel;
  }
}
