package com.wsl.payments.dagger

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wsl.payments.Payments
import com.wsl.payments.retrofit.RetrofitClient
import com.wsl.payments.retrofit.RetrofitServices
import com.wsl.payments.utils.Preferences
import com.wsl.payments.viewmodel.PaymentViewModel
import com.wsl.payments.viewmodel.RepositoryPayments
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun prefs() = Preferences(application)

    @Provides
    @Singleton
    fun repository() = RepositoryPayments.build(application)

    @Singleton
    @Provides
    fun provideRetrofit() = RetrofitClient.build( application ).buildRetrofit()

    @Provides
    @Singleton
    fun retrofitServices(): RetrofitServices = provideRetrofit().create(RetrofitServices::class.java)

//    @Provides
//    @Singleton
//    fun firebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()
//
//    @Singleton
//    @Provides
//    fun googleSignInClient(): GoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//        .requestIdToken(application.getString(R.string.default_web_client_id))
//        .requestProfile()
//        .requestId()
//        .requestEmail()
//        .build()
//
//    @Singleton
//    @Provides
//    fun googleSignInOptions() = GoogleSignIn.getClient(application, googleSignInClient())
//
//    @Singleton
//    @Provides
//    fun callBackManager() = CallbackManager.Factory.create()

}


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: Payments)
    fun inject(repository: RepositoryPayments)
    fun inject(viewModelFactory: RetroViewModelFactory)
    fun inject(retrofit: RetrofitClient)
}

/*******APPLICATION********/
class DaggerApplication {

    private lateinit var apiComponent: AppComponent

    fun getMyComponent(): AppComponent {
        return apiComponent
    }

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
    lateinit var repositoryPayments: RepositoryPayments

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        apiComponent.inject(this)

        if (modelClass.isAssignableFrom(PaymentViewModel::class.java)) {

            return PaymentViewModel().apply { this.repository = repositoryPayments } as T

        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}