package com.wsl.login.login;

import com.facebook.CallbackManager;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.wsl.login.config.Config;
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
public final class WSLoginActivity_MembersInjector implements MembersInjector<WSLoginActivity> {
  private final Provider<CallbackManager> callbackManagerProvider;

  private final Provider<WSLoginViewModel> viewModelProvider;

  private final Provider<GoogleSignInOptions> gsoProvider;

  private final Provider<GoogleSignInClient> mGoogleSignInClientProvider;

  private final Provider<FirebaseAuth> authProvider;

  private final Provider<Config> configClassProvider;

  public WSLoginActivity_MembersInjector(Provider<CallbackManager> callbackManagerProvider,
      Provider<WSLoginViewModel> viewModelProvider, Provider<GoogleSignInOptions> gsoProvider,
      Provider<GoogleSignInClient> mGoogleSignInClientProvider, Provider<FirebaseAuth> authProvider,
      Provider<Config> configClassProvider) {
    this.callbackManagerProvider = callbackManagerProvider;
    this.viewModelProvider = viewModelProvider;
    this.gsoProvider = gsoProvider;
    this.mGoogleSignInClientProvider = mGoogleSignInClientProvider;
    this.authProvider = authProvider;
    this.configClassProvider = configClassProvider;
  }

  public static MembersInjector<WSLoginActivity> create(
      Provider<CallbackManager> callbackManagerProvider,
      Provider<WSLoginViewModel> viewModelProvider, Provider<GoogleSignInOptions> gsoProvider,
      Provider<GoogleSignInClient> mGoogleSignInClientProvider, Provider<FirebaseAuth> authProvider,
      Provider<Config> configClassProvider) {
    return new WSLoginActivity_MembersInjector(callbackManagerProvider, viewModelProvider, gsoProvider, mGoogleSignInClientProvider, authProvider, configClassProvider);
  }

  @Override
  public void injectMembers(WSLoginActivity instance) {
    injectCallbackManager(instance, callbackManagerProvider.get());
    injectViewModel(instance, viewModelProvider.get());
    injectGso(instance, gsoProvider.get());
    injectMGoogleSignInClient(instance, mGoogleSignInClientProvider.get());
    injectAuth(instance, authProvider.get());
    injectConfigClass(instance, configClassProvider.get());
  }

  @InjectedFieldSignature("com.wsl.login.login.WSLoginActivity.callbackManager")
  public static void injectCallbackManager(WSLoginActivity instance,
      CallbackManager callbackManager) {
    instance.callbackManager = callbackManager;
  }

  @InjectedFieldSignature("com.wsl.login.login.WSLoginActivity.viewModel")
  public static void injectViewModel(WSLoginActivity instance, WSLoginViewModel viewModel) {
    instance.viewModel = viewModel;
  }

  @InjectedFieldSignature("com.wsl.login.login.WSLoginActivity.gso")
  public static void injectGso(WSLoginActivity instance, GoogleSignInOptions gso) {
    instance.gso = gso;
  }

  @InjectedFieldSignature("com.wsl.login.login.WSLoginActivity.mGoogleSignInClient")
  public static void injectMGoogleSignInClient(WSLoginActivity instance,
      GoogleSignInClient mGoogleSignInClient) {
    instance.mGoogleSignInClient = mGoogleSignInClient;
  }

  @InjectedFieldSignature("com.wsl.login.login.WSLoginActivity.auth")
  public static void injectAuth(WSLoginActivity instance, FirebaseAuth auth) {
    instance.auth = auth;
  }

  @InjectedFieldSignature("com.wsl.login.login.WSLoginActivity.configClass")
  public static void injectConfigClass(WSLoginActivity instance, Config configClass) {
    instance.configClass = configClass;
  }
}
