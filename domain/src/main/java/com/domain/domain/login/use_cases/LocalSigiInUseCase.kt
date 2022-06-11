package com.domain.domain.login.use_cases

import com.domain.domain.UseCase
import com.domain.domain.login.repository.RepositoryLogin
import com.utils.utils.Failure
import com.utils.utils.Result

class LocalSigiInUseCase(private val repositoryLogin: RepositoryLogin): UseCase<String> {
    override suspend fun invoke(): Result<Failure, String> {
        return repositoryLogin.localSignIn()
    }
}