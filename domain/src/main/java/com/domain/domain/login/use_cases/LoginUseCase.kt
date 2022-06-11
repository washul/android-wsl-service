package com.domain.domain.login.use_cases

import com.domain.domain.ParamsUseCase
import com.domain.domain.login.models.LoginResponse
import com.domain.domain.login.models.User
import com.domain.domain.login.repository.RepositoryLogin
import com.utils.utils.Failure
import com.utils.utils.Result
import com.utils.utils.map

class LoginUseCase(private val repositoryLogin: RepositoryLogin):
    ParamsUseCase<LoginResponse, LoginUseCase.Params> {

    data class Params(val email: String, val password: String)

    override suspend fun invoke(params: Params): Result<Failure, LoginResponse> {
        return repositoryLogin.login(
            email = params.email,
            password = params.password
        )
    }
}