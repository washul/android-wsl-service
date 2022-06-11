package com.domain.domain

import com.utils.utils.Failure
import com.utils.utils.Result

internal interface ParamsUseCase<T, Params> {
    suspend operator fun invoke(params: Params): Result<Failure, T>
}