package com.wsl.login.dagger;

import android.content.Context;
import com.wsl.login.login.view_model.RepositoryLogin;
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
public final class AppModule_RepositoryLoginFactory implements Factory<RepositoryLogin> {
  private final Provider<Context> contextProvider;

  public AppModule_RepositoryLoginFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public RepositoryLogin get() {
    return repositoryLogin(contextProvider.get());
  }

  public static AppModule_RepositoryLoginFactory create(Provider<Context> contextProvider) {
    return new AppModule_RepositoryLoginFactory(contextProvider);
  }

  public static RepositoryLogin repositoryLogin(Context context) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.repositoryLogin(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
