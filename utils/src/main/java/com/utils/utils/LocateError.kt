package com.utils.utils

fun locateError(failure: Failure): Failure =
    when(failure) {
        is Failure.ServerError -> {
            Failure.CustomError("No internet connection")
        }

        else -> { Failure.CustomError("Something went wrong, try again")}
    }

fun locateErrorMessage(failure: Failure): String =
    when(failure) {
        is Failure.ServerError -> {
            "No internet connection"
        }
        else ->  "Something went wrong, try again"
    }