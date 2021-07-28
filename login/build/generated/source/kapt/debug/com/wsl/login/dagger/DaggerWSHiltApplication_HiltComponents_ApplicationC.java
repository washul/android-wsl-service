package com.wsl.login.dagger;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.facebook.CallbackManager;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.auth.FirebaseAuth;
import com.wsl.login.config.Config;
import com.wsl.login.login.WSLoginActivity;
import com.wsl.login.login.WSLoginActivity_MembersInjector;
import com.wsl.login.login.fragments.LoginFragment;
import com.wsl.login.login.fragments.LoginFragment_MembersInjector;
import com.wsl.login.login.fragments.RegisterFragment;
import com.wsl.login.login.fragments.RegisterFragment_MembersInjector;
import com.wsl.login.login.view_model.WSLoginViewModel;
import com.wsl.login.payments.Payments;
import com.wsl.login.payments.Payments_MembersInjector;
import com.wsl.login.payments.viewmodel.WSPaymentViewModel;
import com.wsl.login.profile.ProfileActivity;
import com.wsl.login.profile.ProfileActivity_MembersInjector;
import com.wsl.login.profile.view_model.WSProfileViewModel;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MemoizedSentinel;
import dagger.internal.Preconditions;
import java.util.Set;
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
public final class DaggerWSHiltApplication_HiltComponents_ApplicationC extends WSHiltApplication_HiltComponents.ApplicationC {
  private final ApplicationContextModule applicationContextModule;

  private volatile Object callbackManager = new MemoizedSentinel();

  private volatile Object wSLoginViewModel = new MemoizedSentinel();

  private volatile Object googleSignInOptions = new MemoizedSentinel();

  private volatile Object googleSignInClient = new MemoizedSentinel();

  private volatile Object firebaseAuth = new MemoizedSentinel();

  private volatile Object config = new MemoizedSentinel();

  private volatile Object wSPaymentViewModel = new MemoizedSentinel();

  private volatile Object wSProfileViewModel = new MemoizedSentinel();

  private DaggerWSHiltApplication_HiltComponents_ApplicationC(
      ApplicationContextModule applicationContextModuleParam) {
    this.applicationContextModule = applicationContextModuleParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  private CallbackManager getCallbackManager() {
    Object local = callbackManager;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = callbackManager;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_CallbackManagerFactory.callbackManager();
          callbackManager = DoubleCheck.reentrantCheck(callbackManager, local);
        }
      }
    }
    return (CallbackManager) local;
  }

  private WSLoginViewModel getWSLoginViewModel() {
    Object local = wSLoginViewModel;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = wSLoginViewModel;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideViewModelLoginFactory.provideViewModelLogin(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
          wSLoginViewModel = DoubleCheck.reentrantCheck(wSLoginViewModel, local);
        }
      }
    }
    return (WSLoginViewModel) local;
  }

  private GoogleSignInOptions getGoogleSignInOptions() {
    Object local = googleSignInOptions;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = googleSignInOptions;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_GoogleSiginInOptionsFactory.GoogleSiginInOptions(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
          googleSignInOptions = DoubleCheck.reentrantCheck(googleSignInOptions, local);
        }
      }
    }
    return (GoogleSignInOptions) local;
  }

  private GoogleSignInClient getGoogleSignInClient() {
    Object local = googleSignInClient;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = googleSignInClient;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_MGoogleSignInClientFactory.mGoogleSignInClient(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
          googleSignInClient = DoubleCheck.reentrantCheck(googleSignInClient, local);
        }
      }
    }
    return (GoogleSignInClient) local;
  }

  private FirebaseAuth getFirebaseAuth() {
    Object local = firebaseAuth;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = firebaseAuth;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_FirebaseAuthFactory.firebaseAuth();
          firebaseAuth = DoubleCheck.reentrantCheck(firebaseAuth, local);
        }
      }
    }
    return (FirebaseAuth) local;
  }

  private Config getConfig() {
    Object local = config;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = config;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideConfigClassFactory.provideConfigClass(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
          config = DoubleCheck.reentrantCheck(config, local);
        }
      }
    }
    return (Config) local;
  }

  private WSPaymentViewModel getWSPaymentViewModel() {
    Object local = wSPaymentViewModel;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = wSPaymentViewModel;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideViewModelPaymentsFactory.provideViewModelPayments(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
          wSPaymentViewModel = DoubleCheck.reentrantCheck(wSPaymentViewModel, local);
        }
      }
    }
    return (WSPaymentViewModel) local;
  }

  private WSProfileViewModel getWSProfileViewModel() {
    Object local = wSProfileViewModel;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = wSProfileViewModel;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideViewModelProfileFactory.provideViewModelProfile(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
          wSProfileViewModel = DoubleCheck.reentrantCheck(wSProfileViewModel, local);
        }
      }
    }
    return (WSProfileViewModel) local;
  }

  @Override
  public void injectWSHiltApplication(WSHiltApplication wSHiltApplication) {
  }

  @Override
  public ActivityRetainedComponentBuilder retainedComponentBuilder() {
    return new ActivityRetainedCBuilder();
  }

  @Override
  public ServiceComponentBuilder serviceComponentBuilder() {
    return new ServiceCBuilder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder appModule(AppModule appModule) {
      Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public WSHiltApplication_HiltComponents.ApplicationC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new DaggerWSHiltApplication_HiltComponents_ApplicationC(applicationContextModule);
    }
  }

  private final class ActivityRetainedCBuilder implements WSHiltApplication_HiltComponents.ActivityRetainedC.Builder {
    @Override
    public WSHiltApplication_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl();
    }
  }

  private final class ActivityRetainedCImpl extends WSHiltApplication_HiltComponents.ActivityRetainedC {
    private ActivityRetainedCImpl() {

    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder();
    }

    private final class ActivityCBuilder implements WSHiltApplication_HiltComponents.ActivityC.Builder {
      private Activity activity;

      @Override
      public ActivityCBuilder activity(Activity activity) {
        this.activity = Preconditions.checkNotNull(activity);
        return this;
      }

      @Override
      public WSHiltApplication_HiltComponents.ActivityC build() {
        Preconditions.checkBuilderRequirement(activity, Activity.class);
        return new ActivityCImpl(activity);
      }
    }

    private final class ActivityCImpl extends WSHiltApplication_HiltComponents.ActivityC {
      private final Activity activity;

      private ActivityCImpl(Activity activityParam) {
        this.activity = activityParam;
      }

      private ViewModelProvider.Factory getProvideFactory() {
        return ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory.provideFactory(activity, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerWSHiltApplication_HiltComponents_ApplicationC.this.applicationContextModule), ImmutableMap.<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>>of());
      }

      @Override
      public void injectWSLoginActivity(WSLoginActivity wSLoginActivity) {
        injectWSLoginActivity2(wSLoginActivity);
      }

      @Override
      public void injectPayments(Payments payments) {
        injectPayments2(payments);
      }

      @Override
      public void injectProfileActivity(ProfileActivity profileActivity) {
        injectProfileActivity2(profileActivity);
      }

      @Override
      public Set<ViewModelProvider.Factory> getActivityViewModelFactory() {
        return ImmutableSet.<ViewModelProvider.Factory>of(getProvideFactory());
      }

      @Override
      public FragmentComponentBuilder fragmentComponentBuilder() {
        return new FragmentCBuilder();
      }

      @Override
      public ViewComponentBuilder viewComponentBuilder() {
        return new ViewCBuilder();
      }

      @CanIgnoreReturnValue
      private WSLoginActivity injectWSLoginActivity2(WSLoginActivity instance) {
        WSLoginActivity_MembersInjector.injectCallbackManager(instance, DaggerWSHiltApplication_HiltComponents_ApplicationC.this.getCallbackManager());
        WSLoginActivity_MembersInjector.injectViewModel(instance, DaggerWSHiltApplication_HiltComponents_ApplicationC.this.getWSLoginViewModel());
        WSLoginActivity_MembersInjector.injectGso(instance, DaggerWSHiltApplication_HiltComponents_ApplicationC.this.getGoogleSignInOptions());
        WSLoginActivity_MembersInjector.injectMGoogleSignInClient(instance, DaggerWSHiltApplication_HiltComponents_ApplicationC.this.getGoogleSignInClient());
        WSLoginActivity_MembersInjector.injectAuth(instance, DaggerWSHiltApplication_HiltComponents_ApplicationC.this.getFirebaseAuth());
        WSLoginActivity_MembersInjector.injectConfigClass(instance, DaggerWSHiltApplication_HiltComponents_ApplicationC.this.getConfig());
        return instance;
      }

      @CanIgnoreReturnValue
      private Payments injectPayments2(Payments instance) {
        Payments_MembersInjector.injectViewModel(instance, DaggerWSHiltApplication_HiltComponents_ApplicationC.this.getWSPaymentViewModel());
        return instance;
      }

      @CanIgnoreReturnValue
      private ProfileActivity injectProfileActivity2(ProfileActivity instance) {
        ProfileActivity_MembersInjector.injectViewModel(instance, DaggerWSHiltApplication_HiltComponents_ApplicationC.this.getWSProfileViewModel());
        return instance;
      }

      private final class FragmentCBuilder implements WSHiltApplication_HiltComponents.FragmentC.Builder {
        private Fragment fragment;

        @Override
        public FragmentCBuilder fragment(Fragment fragment) {
          this.fragment = Preconditions.checkNotNull(fragment);
          return this;
        }

        @Override
        public WSHiltApplication_HiltComponents.FragmentC build() {
          Preconditions.checkBuilderRequirement(fragment, Fragment.class);
          return new FragmentCImpl(fragment);
        }
      }

      private final class FragmentCImpl extends WSHiltApplication_HiltComponents.FragmentC {
        private final Fragment fragment;

        private FragmentCImpl(Fragment fragmentParam) {
          this.fragment = fragmentParam;
        }

        private ViewModelProvider.Factory getProvideFactory() {
          return ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory.provideFactory(fragment, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerWSHiltApplication_HiltComponents_ApplicationC.this.applicationContextModule), ImmutableMap.<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>>of());
        }

        @Override
        public void injectLoginFragment(LoginFragment loginFragment) {
          injectLoginFragment2(loginFragment);
        }

        @Override
        public void injectRegisterFragment(RegisterFragment registerFragment) {
          injectRegisterFragment2(registerFragment);
        }

        @Override
        public Set<ViewModelProvider.Factory> getFragmentViewModelFactory() {
          return ImmutableSet.<ViewModelProvider.Factory>of(getProvideFactory());
        }

        @Override
        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
          return new ViewWithFragmentCBuilder();
        }

        @CanIgnoreReturnValue
        private LoginFragment injectLoginFragment2(LoginFragment instance) {
          LoginFragment_MembersInjector.injectCallbackManager(instance, DaggerWSHiltApplication_HiltComponents_ApplicationC.this.getCallbackManager());
          LoginFragment_MembersInjector.injectGso(instance, DaggerWSHiltApplication_HiltComponents_ApplicationC.this.getGoogleSignInOptions());
          LoginFragment_MembersInjector.injectMGoogleSignInClient(instance, DaggerWSHiltApplication_HiltComponents_ApplicationC.this.getGoogleSignInClient());
          LoginFragment_MembersInjector.injectAuth(instance, DaggerWSHiltApplication_HiltComponents_ApplicationC.this.getFirebaseAuth());
          LoginFragment_MembersInjector.injectViewModel(instance, DaggerWSHiltApplication_HiltComponents_ApplicationC.this.getWSLoginViewModel());
          return instance;
        }

        @CanIgnoreReturnValue
        private RegisterFragment injectRegisterFragment2(RegisterFragment instance) {
          RegisterFragment_MembersInjector.injectViewModel(instance, DaggerWSHiltApplication_HiltComponents_ApplicationC.this.getWSLoginViewModel());
          return instance;
        }

        private final class ViewWithFragmentCBuilder implements WSHiltApplication_HiltComponents.ViewWithFragmentC.Builder {
          private View view;

          @Override
          public ViewWithFragmentCBuilder view(View view) {
            this.view = Preconditions.checkNotNull(view);
            return this;
          }

          @Override
          public WSHiltApplication_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(view, View.class);
            return new ViewWithFragmentCImpl(view);
          }
        }

        private final class ViewWithFragmentCImpl extends WSHiltApplication_HiltComponents.ViewWithFragmentC {
          private ViewWithFragmentCImpl(View view) {

          }
        }
      }

      private final class ViewCBuilder implements WSHiltApplication_HiltComponents.ViewC.Builder {
        private View view;

        @Override
        public ViewCBuilder view(View view) {
          this.view = Preconditions.checkNotNull(view);
          return this;
        }

        @Override
        public WSHiltApplication_HiltComponents.ViewC build() {
          Preconditions.checkBuilderRequirement(view, View.class);
          return new ViewCImpl(view);
        }
      }

      private final class ViewCImpl extends WSHiltApplication_HiltComponents.ViewC {
        private ViewCImpl(View view) {

        }
      }
    }
  }

  private final class ServiceCBuilder implements WSHiltApplication_HiltComponents.ServiceC.Builder {
    private Service service;

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public WSHiltApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(service);
    }
  }

  private final class ServiceCImpl extends WSHiltApplication_HiltComponents.ServiceC {
    private ServiceCImpl(Service service) {

    }
  }
}
