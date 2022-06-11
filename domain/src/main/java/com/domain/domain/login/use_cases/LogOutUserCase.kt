package com.domain.domain.login.use_cases

import com.domain.domain.UseCase
import com.domain.domain.login.repository.RepositoryLogin
import com.utils.utils.Failure
import com.utils.utils.Result

class LogOutUserCase(private val repositoryLogin: RepositoryLogin): UseCase<Boolean> {
    override suspend fun invoke(): Result<Failure, Boolean> {
        return repositoryLogin.logOut()
    }
}