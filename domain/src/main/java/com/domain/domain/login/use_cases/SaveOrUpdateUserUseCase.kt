package com.domain.domain.login.use_cases

import com.domain.domain.ParamsUseCase
import com.domain.domain.login.models.User
import com.domain.domain.login.repository.RepositoryLogin
import com.utils.utils.Failure
import com.utils.utils.Result

class SaveOrUpdateUserUseCase(private val repositoryLogin: RepositoryLogin): ParamsUseCase<Boolean, SaveOrUpdateUserUseCase.Params> {
    data class Params(val user: User)

    override suspend fun invoke(params: Params): Result<Failure, Boolean> {
        return repositoryLogin.saveUserOrUpdate(params.user)
    }
}