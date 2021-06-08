package com.wsl.login.login.fragments;

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
public final class LoginFragment_MembersInjector implements MembersInjector<LoginFragment> {
  private final Provider<CallbackManager> callbackManagerProvider;

  private final Provider<GoogleSignInOptions> gsoProvider;

  private final Provider<GoogleSignInClient> mGoogleSignInClientProvider;

  private final Provider<FirebaseAuth> authProvider;

  private final Provider<WSLoginViewModel> viewModelProvider;

  public LoginFragment_MembersInjector(Provider<CallbackManager> callbackManagerProvider,
      Provider<GoogleSignInOptions> gsoProvider,
      Provider<GoogleSignInClient> mGoogleSignInClientProvider, Provider<FirebaseAuth> authProvider,
      Provider<WSLoginViewModel> viewModelProvider) {
    this.callbackManagerProvider = callbackManagerProvider;
    this.gsoProvider = gsoProvider;
    this.mGoogleSignInClientProvider = mGoogleSignInClientProvider;
    this.authProvider = authProvider;
    this.viewModelProvider = viewModelProvider;
  }

  public static MembersInjector<LoginFragment> create(
      Provider<CallbackManager> callbackManagerProvider, Provider<GoogleSignInOptions> gsoProvider,
      Provider<GoogleSignInClient> mGoogleSignInClientProvider, Provider<FirebaseAuth> authProvider,
      Provider<WSLoginViewModel> viewModelProvider) {
    return new LoginFragment_MembersInjector(callbackManagerProvider, gsoProvider, mGoogleSignInClientProvider, authProvider, viewModelProvider);
  }

  @Override
  public void injectMembers(LoginFragment instance) {
    injectCallbackManager(instance, callbackManagerProvider.get());
    injectGso(instance, gsoProvider.get());
    injectMGoogleSignInClient(instance, mGoogleSignInClientProvider.get());
    injectAuth(instance, authProvider.get());
    injectViewModel(instance, viewModelProvider.get());
  }

  @InjectedFieldSignature("com.wsl.login.login.fragments.LoginFragment.callbackManager")
  public static void injectCallbackManager(LoginFragment instance,
      CallbackManager callbackManager) {
    instance.callbackManager = callbackManager;
  }

  @InjectedFieldSignature("com.wsl.login.login.fragments.LoginFragment.gso")
  public static void injectGso(LoginFragment instance, GoogleSignInOptions gso) {
    instance.gso = gso;
  }

  @InjectedFieldSignature("com.wsl.login.login.fragments.LoginFragment.mGoogleSignInClient")
  public static void injectMGoogleSignInClient(LoginFragment instance,
      GoogleSignInClient mGoogleSignInClient) {
    instance.mGoogleSignInClient = mGoogleSignInClient;
  }

  @InjectedFieldSignature("com.wsl.login.login.fragments.LoginFragment.auth")
  public static void injectAuth(LoginFragment instance, FirebaseAuth auth) {
    instance.auth = auth;
  }

  @InjectedFieldSignature("com.wsl.login.login.fragments.LoginFragment.viewModel")
  public static void injectViewModel(LoginFragment instance, WSLoginViewModel viewModel) {
    instance.viewModel = viewModel;
  }
}
