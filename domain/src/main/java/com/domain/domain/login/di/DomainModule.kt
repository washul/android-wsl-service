package com.domain.domain.login.di

import com.domain.domain.login.use_cases.*
import org.koin.dsl.module

val domainModule = module {
    factory { GetSensitiveTokensUseCase(get()) }
    factory { GetUserUseCase(get()) }
    factory { LocalSigiInUseCase(get()) }
    factory { LoginUseCase(get()) }
    factory { LogOutUserCase(get()) }
    factory { RegisterUserUseCase(get()) }
    factory { SaveOrUpdateUserUseCase(get()) }
    factory { UpdateUserUseCase(get()) }
    factory { SetUserIDUseCase(get()) }
    factory { SetDeviceIDUseCase(get()) }
    factory { SetTokenUserUseCase(get()) }
}