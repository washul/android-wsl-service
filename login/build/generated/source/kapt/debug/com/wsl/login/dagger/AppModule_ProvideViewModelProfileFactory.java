package com.wsl.login.dagger;

import android.content.Context;
import com.wsl.login.profile.view_model.WSProfileViewModel;
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
public final class AppModule_ProvideViewModelProfileFactory implements Factory<WSProfileViewModel> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideViewModelProfileFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public WSProfileViewModel get() {
    return provideViewModelProfile(contextProvider.get());
  }

  public static AppModule_ProvideViewModelProfileFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideViewModelProfileFactory(contextProvider);
  }

  public static WSProfileViewModel provideViewModelProfile(Context context) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.provideViewModelProfile(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
