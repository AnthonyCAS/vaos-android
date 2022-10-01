package com.android.vaos.core.repository

import com.android.vaos.core.model.user.User
import com.android.vaos.core.utils.ApiResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun registerUser(
        userName: String
    ): Flow<ApiResponse<Unit>>

    fun getUser(
        userId: String,
    ): Flow<ApiResponse<User>>
}
