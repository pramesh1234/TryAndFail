package com.app.tryandfail.domain.models

sealed class ResultState<T>(
    val data: T? = null,
    val message: String? = null,
    val code: Int? = null,
    val error: Throwable? = null
) {
    class Success<T>(data: T? = null, message: String? = null, code: Int? = null) :
        ResultState<T>(data, message, code)

    class Loading<T>(data: T? = null) : ResultState<T>(data)
    class Error<T>(
        message: String = "Something went wrong",
        data: T? = null,
        error: Throwable? = null,
        code: Int? = null
    ) : ResultState<T>(data, message, error = error, code = code)
}