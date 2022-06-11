package com.wsl.login.di

import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.wsl.login.R
import com.wsl.login.config.Config
import com.wsl.login.login.CommonAuthenticationManager
import com.wsl.login.login.view_model.WSLoginViewModel
//import com.wsl.login.profile.view_model.WSProfileViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val loginModule = module {
    factory { GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(androidContext().getString(R.string.default_web_client_id))
        .requestEmail()
        .requestProfile()
        .build() }
    factory { GoogleSignIn.getClient(androidContext(), get()) }
    factory { FirebaseAuth.getInstance() }
    factory { Config(androidContext()) }
    factory {
        CommonAuthenticationManager(
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
}

val viewModelModule = module {
    viewModel { WSLoginViewModel(get()) }
//    viewModel { WSPaymentViewModel(get()) }
//    viewModel { WSProfileViewModel(get(), get()) }
}