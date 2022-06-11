package com.domain.domain.login.use_cases

import com.domain.domain.UseCase
import com.domain.domain.login.models.LoginResponse
import com.domain.domain.login.repository.RepositoryLogin
import com.utils.utils.Failure
import com.utils.utils.Result

class GetUserUseCase(private val repositoryLogin: RepositoryLogin): UseCase<LoginResponse> {
    override suspend fun invoke(): Result<Failure, LoginResponse> {
        return repositoryLogin.getUser()
    }
}