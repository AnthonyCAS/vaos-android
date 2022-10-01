package com.android.vaos.core.repository

import com.android.vaos.core.model.user.User
import com.android.vaos.core.remote.service.ApiService
import com.android.vaos.core.utils.ApiResponse
import com.android.vaos.core.utils.BaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImp @Inject constructor(
    private val apiService: ApiService
) : UserRepository, BaseRepository() {

    override fun registerUser(userName: String): Flow<ApiResponse<Unit>> {
        TODO("Not yet implemented")
    }

    override fun getUser(userId: String): Flow<ApiResponse<User>> {
        TODO("Not yet implemented")
    }
}
