package com.utils.utils

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [FeatureFailure] class.
 */
sealed class Failure {
    object NetworkConnection : Failure()
    data class ServerError(val throws: Throwable) : Failure()
    data class CleengRequestError(val errorMessage: String) : Failure()
    data class CommonRequestError(val errorMessage: String, val errorCode: String? = null) : Failure()
    data class CustomError(val errorMessage: String) : Failure()
    object NoContent : Failure()

    fun logError() {
        when (this) {
            is ServerError -> L.e(
                TAG,
                throws.message
            );
            is CleengRequestError -> L.e(
                TAG,
                errorMessage
            )
            is CommonRequestError -> L.e(TAG, errorMessage)
            is NoContent -> L.e(TAG, "No content")
            is CustomError -> L.e(TAG, "Custom Error: $errorMessage")

            else -> L.e(
                TAG,
                UNKNOWN_ERROR
            )
        }
    }

    fun getError() = when (this) {
        is ServerError -> throws.message
        is CleengRequestError -> errorMessage
        is CustomError -> errorMessage
        is CommonRequestError -> errorMessage
        else -> UNKNOWN_ERROR
    }

    fun throws(): Nothing = throw when (this) {
        is ServerError -> throws
        is CleengRequestError -> CleengRequestErrorException(errorMessage)
        is CustomError -> Exception(errorMessage)
        is CommonRequestError -> VindiciaRequestErrorException(errorMessage)
        else -> Exception(UNKNOWN_ERROR)
    }

    companion object {
        val TAG = Failure::class.simpleName
        internal val UNKNOWN_ERROR: String = "Something went wrong"
    }

    private inner class CleengRequestErrorException(message: String) : Exception(message)
    private inner class VindiciaRequestErrorException(message: String) : Exception(message)
}