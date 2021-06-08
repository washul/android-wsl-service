package com.wsl.login.login;

import com.facebook.CallbackManager;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
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
  private final Provider<WSLoginViewModel> viewModelProvider;

  private final Provider<CallbackManager> callbackManagerProvider;

  private final Provider<GoogleSignInOptions> gsoProvider;

  private final Provider<GoogleSignInClient> mGoogleSignInClientProvider;

  private final Provider<FirebaseAuth> authProvider;

  public WSLoginActivity_MembersInjector(Provider<WSLoginViewModel> viewModelProvider,
      Provider<CallbackManager> callbackManagerProvider, Provider<GoogleSignInOptions> gsoProvider,
      Provider<GoogleSignInClient> mGoogleSignInClientProvider,
      Provider<FirebaseAuth> authProvider) {
    this.viewModelProvider = viewModelProvider;
    this.callbackManagerProvider = callbackManagerProvider;
    this.gsoProvider = gsoProvider;
    this.mGoogleSignInClientProvider = mGoogleSignInClientProvider;
    this.authProvider = authProvider;
  }

  public static MembersInjector<WSLoginActivity> create(
      Provider<WSLoginViewModel> viewModelProvider,
      Provider<CallbackManager> callbackManagerProvider, Provider<GoogleSignInOptions> gsoProvider,
      Provider<GoogleSignInClient> mGoogleSignInClientProvider,
      Provider<FirebaseAuth> authProvider) {
    return new WSLoginActivity_MembersInjector(viewModelProvider, callbackManagerProvider, gsoProvider, mGoogleSignInClientProvider, authProvider);
  }

  @Override
  public void injectMembers(WSLoginActivity instance) {
    injectViewModel(instance, viewModelProvider.get());
    injectCallbackManager(instance, callbackManagerProvider.get());
    injectGso(instance, gsoProvider.get());
    injectMGoogleSignInClient(instance, mGoogleSignInClientProvider.get());
    injectAuth(instance, authProvider.get());
  }

  @InjectedFieldSignature("com.wsl.login.login.WSLoginActivity.viewModel")
  public static void injectViewModel(WSLoginActivity instance, WSLoginViewModel viewModel) {
    instance.viewModel = viewModel;
  }

  @InjectedFieldSignature("com.wsl.login.login.WSLoginActivity.callbackManager")
  public static void injectCallbackManager(WSLoginActivity instance,
      CallbackManager callbackManager) {
    instance.callbackManager = callbackManager;
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
}
