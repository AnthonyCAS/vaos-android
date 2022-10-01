package com.android.vaos.core.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import retrofit2.Response

open class BaseRepository {

    fun <P, T : Response<P>> fetchData(
        dataSource: Flow<T>
    ) =
        dataSource.map { result ->
            val data = result.body()
            if (result.isSuccessful && data != null) {
                ApiResponse.Success(data)
            } else {
                ApiResponse.Error(ERROR_MSG)
            }
        }.catch { throwable ->
            emit(ApiResponse.Error(throwable.message))
        }.onStart {
            emit(ApiResponse.Loading)
        }

    companion object {
        const val ERROR_MSG = "Error"
    }
}
