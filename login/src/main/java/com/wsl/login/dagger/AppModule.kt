package com.wsl.login.dagger

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.facebook.CallbackManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.wsl.login.R
import com.wsl.login.retrofit.RetrofitClient
import com.wsl.login.login.WSLoginActivity
import com.wsl.login.helpers.Preferences
import com.wsl.login.login.view_model.LoginViewModel
import com.wsl.login.login.view_model.RepositoryLogin
import com.wsl.login.database.AppDataBase
import com.wsl.login.payments.Payments
import com.wsl.login.payments.viewmodel.PaymentViewModel
import com.wsl.login.payments.viewmodel.RepositoryPayments
import com.wsl.login.retrofit.RetrofitServices
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun prefs() = Preferences(application)

    @Provides
    @Singleton
    fun repositoryLogin() = RepositoryLogin.build(application)

    @Provides
    @Singleton
    fun repositoryPayments() = RepositoryPayments.build(application)

    @Singleton
    @Provides
    fun appDataBase() = AppDataBase.getInstance( application )!!

    @Singleton
    @Provides
    fun provideRetrofit() = RetrofitClient.build( application ).buildRetrofit()

    @Provides
    @Singleton
    fun retrofitServices() = provideRetrofit().create(RetrofitServices::class.java)

    @Provides
    @Singleton
    fun compositeDisposable() = CompositeDisposable()

    @Provides
    @Singleton
    fun callbackManager() = CallbackManager.Factory.create()

    @Provides
    @Singleton
    fun GoogleSiginInOptions() = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(application.getString(R.string.default_web_client_id))
        .requestEmail()
        .build()

    @Provides
    @Singleton
    fun mGoogleSignInClient() = GoogleSignIn.getClient(application, GoogleSiginInOptions());

    @Provides
    @Singleton
    fun firebaseAuth() = FirebaseAuth.getInstance()



}


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: WSLoginActivity)
    fun inject(activity: Payments)
    fun inject(repository: RepositoryLogin)
    fun inject(repository: RepositoryPayments)
    fun inject(viewModelLogin: LoginViewModel)
    fun inject(viewModelPayment: PaymentViewModel)
    fun inject(viewModelFactory: RetroViewModelFactory)
    fun inject(retrofit: RetrofitClient)
}

/*******APPLICATION********/
class DaggerApplication {

    private lateinit var apiComponent: AppComponent

    fun initDaggerComponent(application: Application): AppComponent {
        apiComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(application))
            .build()
        return  apiComponent

    }

}


class RetroViewModelFactory(appComponent: AppComponent) : ViewModelProvider.Factory {

    private var apiComponent: AppComponent = appComponent

    @Inject
    lateinit var repositoryLogin: RepositoryLogin

    @Inject
    lateinit var repositoryPayments: RepositoryPayments

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        apiComponent.inject(this)

        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {

            return LoginViewModel().apply { this.repository = repositoryLogin } as T

        }else if (modelClass.isAssignableFrom(PaymentViewModel::class.java)) {

            return PaymentViewModel().apply { this.repository = repositoryPayments } as T

        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}