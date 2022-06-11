package com.domain.domain

import com.utils.utils.Failure
import com.utils.utils.Result

internal interface UseCaseNoSuspend<T> {
    operator fun invoke(): Result<Failure, T>
}