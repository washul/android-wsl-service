package com.wsl.login.dagger;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
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
public final class AppModule_GoogleSiginInOptionsFactory implements Factory<GoogleSignInOptions> {
  private final Provider<Context> contextProvider;

  public AppModule_GoogleSiginInOptionsFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public GoogleSignInOptions get() {
    return GoogleSiginInOptions(contextProvider.get());
  }

  public static AppModule_GoogleSiginInOptionsFactory create(Provider<Context> contextProvider) {
    return new AppModule_GoogleSiginInOptionsFactory(contextProvider);
  }

  public static GoogleSignInOptions GoogleSiginInOptions(Context context) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.GoogleSiginInOptions(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
