package com.android.vaos.core.utils

import kotlinx.coroutines.flow.Flow

sealed class ApiResponse<out T : Any> {
    data class Success<out T : Any>(val data: T) : ApiResponse<T>()
    data class Error(val message: String?) : ApiResponse<Nothing>()
    object Loading : ApiResponse<Nothing>()
}

inline fun <T : Any> ApiResponse<T>.onSuccess(action: (T) -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Success) action(data)
    return this
}

inline fun <T : Any> ApiResponse<T>.onError(action: (String?) -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Error) action(message)
    return this
}

inline fun <T : Any> ApiResponse<T>.onLoading(action: () -> Unit): ApiResponse<T> {
    if (this == ApiResponse.Loading) action()
    return this
}

private inline fun <T : Any> ApiResponse<T>.onResult(action: ApiResponse<T>.() -> Unit) {
    action()
}

suspend fun <T : Any> Flow<ApiResponse<T>>.collectResult(
    action: ApiResponse<T>.() -> Unit
) {
    collect { value ->
        value.onResult(action)
    }
}
