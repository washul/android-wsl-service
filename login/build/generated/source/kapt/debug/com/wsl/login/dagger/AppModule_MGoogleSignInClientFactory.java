package com.wsl.login.dagger;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
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
public final class AppModule_MGoogleSignInClientFactory implements Factory<GoogleSignInClient> {
  private final Provider<Context> contextProvider;

  public AppModule_MGoogleSignInClientFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public GoogleSignInClient get() {
    return mGoogleSignInClient(contextProvider.get());
  }

  public static AppModule_MGoogleSignInClientFactory create(Provider<Context> contextProvider) {
    return new AppModule_MGoogleSignInClientFactory(contextProvider);
  }

  public static GoogleSignInClient mGoogleSignInClient(Context context) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.mGoogleSignInClient(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
