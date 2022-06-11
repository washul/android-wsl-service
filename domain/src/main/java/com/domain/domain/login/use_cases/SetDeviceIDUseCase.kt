package com.domain.domain.login.use_cases

import com.domain.domain.ParamsUseCase
import com.domain.domain.login.repository.RepositoryLogin
import com.utils.utils.Failure
import com.utils.utils.Result

class SetDeviceIDUseCase(
    private val repositoryLogin: RepositoryLogin
    ): ParamsUseCase<Boolean, SetDeviceIDUseCase.Params> {
    data class Params(val deviceID: String)

    override suspend fun invoke(params: Params): Result<Failure, Boolean> {
        return repositoryLogin.setTokenDevice(params.deviceID)
    }
}