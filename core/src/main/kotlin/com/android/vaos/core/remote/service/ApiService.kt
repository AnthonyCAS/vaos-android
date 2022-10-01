package com.android.vaos.core.remote.service

import com.android.vaos.core.model.user.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("v1/auth/account/verification/{code}")
    suspend fun getUser(
        @Path("userId") userId: String
    ): Flow<Response<User>>

    @POST("v1/auth/account")
    suspend fun registerUser(@Path("userName") userName: String): Flow<Response<Unit>>
}
