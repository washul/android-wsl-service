package com.wsl.login.dagger

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wsl.login.Utils.retrofit.RetrofitClient
import com.wsl.login.Utils.retrofit.RetrofitServices
import com.wsl.login.WSLoginActivity
import com.wsl.login.helpers.Preferences
import com.wsl.login.view_model.LoginViewModel
import com.wsl.login.view_model.RepositoryLogin
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
    fun repository() = RepositoryLogin.build(application)

    @Singleton
    @Provides
    fun provideRetrofit() = RetrofitClient.build( application ).buildRetrofit()

    @Provides
    @Singleton
    fun retrofitServices() = provideRetrofit().create(RetrofitServices::class.java)


}


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: WSLoginActivity)
    fun inject(repository: RepositoryLogin)
    fun inject(viewModelLogin: LoginViewModel)
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
    lateinit var repositoryLogin: RepositoryLogin

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        apiComponent.inject(this)

        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {

            return LoginViewModel().apply { this.repository = repositoryLogin } as T

        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}