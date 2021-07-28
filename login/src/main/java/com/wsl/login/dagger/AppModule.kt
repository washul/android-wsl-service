package com.wsl.login.dagger

import android.content.Context
import com.facebook.CallbackManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.wsl.login.R
import com.wsl.login.config.Config
import com.wsl.login.retrofit.RetrofitClient
import com.wsl.login.helpers.WSPreferences
import com.wsl.login.login.view_model.RepositoryLogin
import com.wsl.login.database.AppDataBase
import com.wsl.login.database.entities.EUser
import com.wsl.login.login.view_model.WSLoginViewModel
import com.wsl.login.payments.viewmodel.WSPaymentViewModel
import com.wsl.login.payments.viewmodel.RepositoryPayments
import com.wsl.login.profile.view_model.WSProfileViewModel
import com.wsl.login.retrofit.RetrofitServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideViewModelLogin(
        @ApplicationContext context: Context
    ) = WSLoginViewModel(repositoryLogin(context))

    @Provides
    @Singleton
    fun provideViewModelPayments(
        @ApplicationContext context: Context
    ) = WSPaymentViewModel(repositoryPayments(context))

    @Provides
    @Singleton
    fun provideViewModelProfile(
        @ApplicationContext context: Context
    ) = WSProfileViewModel(
        repositoryLogin(context),
        repositoryPayments(context)
    )

    @Provides
    @Singleton
    fun prefs(
        @ApplicationContext context: Context
    ) = WSPreferences(context)

    @Provides
    @Singleton
    fun repositoryLogin(
        @ApplicationContext context: Context
    ) = RepositoryLogin(
        db = appDataBase(context),
        prefs = prefs(context),
        service = retrofitServices(context)
    )

    @Provides
    @Singleton
    fun repositoryPayments(
        @ApplicationContext context: Context
    ) = RepositoryPayments(
        appDataBase(context),
        retrofitServices(context)
    )

    @Singleton
    @Provides
    fun appDataBase(
        @ApplicationContext context: Context
    ) = AppDataBase.getInstance( context )!!

    @Singleton
    @Provides
    fun provideRetrofit(
        @ApplicationContext context: Context
    ) = RetrofitClient.build(
        prefs(context)
    ).retrofit

    @Provides
    @Singleton
    fun retrofitServices(
        @ApplicationContext context: Context
    ) = provideRetrofit(context)!!.create(RetrofitServices::class.java)

    @Provides
    @Singleton
    fun callbackManager() = CallbackManager.Factory.create()

    @Provides
    @Singleton
    fun GoogleSiginInOptions(@ApplicationContext context: Context) = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(context.getString(R.string.default_web_client_id))
        .requestEmail()
        .requestProfile()
        .build()

    @Provides
    @Singleton
    fun mGoogleSignInClient(@ApplicationContext context: Context) = GoogleSignIn.getClient(context, GoogleSiginInOptions(context));

    @Provides
    @Singleton
    fun firebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideConfigClass(@ApplicationContext context: Context) = Config(context)
}