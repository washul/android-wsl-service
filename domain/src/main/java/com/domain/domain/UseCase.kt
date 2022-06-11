package com.domain.domain

import com.utils.utils.Failure
import com.utils.utils.Result

internal interface UseCase<T> {
    suspend operator fun invoke(): Result<Failure, T>
}