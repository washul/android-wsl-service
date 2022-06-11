package com.domain.domain.login.use_cases

import com.domain.domain.UseCaseNoSuspend
import com.domain.domain.login.models.SensitiveTokens
import com.domain.domain.login.repository.RepositoryLogin
import com.utils.utils.Failure
import com.utils.utils.Result

class GetSensitiveTokensUseCase(private val repositoryLogin: RepositoryLogin):
    UseCaseNoSuspend<SensitiveTokens> {

    override fun invoke(): Result<Failure, SensitiveTokens> {
        return repositoryLogin.getSensitiveTokens()
    }
}