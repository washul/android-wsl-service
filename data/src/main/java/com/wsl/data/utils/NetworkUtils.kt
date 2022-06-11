package com.wsl.data.utils

import com.google.gson.Gson
import com.utils.utils.Result
import com.utils.utils.Failure
import com.utils.utils.L
import org.json.JSONObject
import retrofit2.Response

/**
 * This method is needed to handle the failures from Vindicia since we have different types of calls
 * @return Result<Failure, T> for the failure it will always return one of the follow:
 * - VindiciaRequestError
 * - ServerError
 * */
inline fun <T> CommonRequest(
    call: () -> Response<T>,
    default: T
): Result<Failure, T> {
    return try {
        val response = call.invoke()
        when (response.isSuccessful) {
            true -> Result.Success(response.body() ?: default)
            false -> {
                val gson = Gson()
                val responseString = response.errorBody()?.string().orEmpty()
                Result.Failure(
                    Failure.CommonRequestError(
                        errorMessage = responseString,
                        errorCode = "1"
                    )
                )
            }
        }
    } catch (exception: Throwable) {
        L.e("Network", exception.toString())
        Result.Failure(
            Failure.ServerError(exception)
        )
    }
}

/**TODO: crear un los errores data*/