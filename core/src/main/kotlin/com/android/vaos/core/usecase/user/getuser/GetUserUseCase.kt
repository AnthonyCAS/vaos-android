package com.android.vaos.core.usecase.user.getuser

import com.android.vaos.core.model.user.User
import com.android.vaos.core.utils.ApiResponse
import kotlinx.coroutines.flow.Flow

interface GetUserUseCase {
    operator fun invoke(userUUID: String): Flow<ApiResponse<User>>
}
