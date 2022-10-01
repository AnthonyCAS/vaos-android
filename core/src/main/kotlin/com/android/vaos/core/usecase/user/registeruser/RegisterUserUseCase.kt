package com.android.vaos.core.usecase.user.registeruser

import com.android.vaos.core.utils.ApiResponse
import kotlinx.coroutines.flow.Flow

interface RegisterUserUseCase {
    operator fun invoke(userName: String): Flow<ApiResponse<Unit>>
}
