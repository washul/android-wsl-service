package com.domain.domain.login.use_cases

import com.domain.domain.ParamsUseCase
import com.domain.domain.login.repository.RepositoryLogin
import com.utils.utils.Failure
import com.utils.utils.Result

class SetTokenUserUseCase(private val repositoryLogin: RepositoryLogin): ParamsUseCase<Boolean, SetTokenUserUseCase.Params> {
    data class Params(val tokenUser: String)

    override suspend fun invoke(params: Params): Result<Failure, Boolean> {
        return repositoryLogin.setTokenUSer(params.tokenUser)
    }

}