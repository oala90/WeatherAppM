package com.example.weatherappmphasis.domain.usecases.base

sealed class Response<out T> {
    data class Success<out T>(val response: T) : Response<T>()

    data class Failure(val error: Exception) : Response<Nothing>()

    fun fold(onSuccess: (T) -> Unit= {}, onFailure: (Exception) -> Unit = {}): Any =
        when (this) {
            is Success -> onSuccess(response)
            is Failure -> onFailure(error)
        }

    suspend fun subscribe(onSuccess: suspend (T) -> Any = {}, onFailure: suspend (Exception) -> Any = {}): Any =
        when (this) {
            is Success -> onSuccess(response)
            is Failure -> onFailure(error)
        }
}