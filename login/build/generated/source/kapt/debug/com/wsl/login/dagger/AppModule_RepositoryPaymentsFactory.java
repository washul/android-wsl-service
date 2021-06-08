package com.wsl.login.dagger;

import android.content.Context;
import com.wsl.login.payments.viewmodel.RepositoryPayments;
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
public final class AppModule_RepositoryPaymentsFactory implements Factory<RepositoryPayments> {
  private final Provider<Context> contextProvider;

  public AppModule_RepositoryPaymentsFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public RepositoryPayments get() {
    return repositoryPayments(contextProvider.get());
  }

  public static AppModule_RepositoryPaymentsFactory create(Provider<Context> contextProvider) {
    return new AppModule_RepositoryPaymentsFactory(contextProvider);
  }

  public static RepositoryPayments repositoryPayments(Context context) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.repositoryPayments(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
