package com.android.vaos.util.preference

import kotlinx.coroutines.flow.Flow

interface DataStoreManager {
    suspend fun storeUserUUID(userUUID: String)
    fun getUserUUID(): Flow<String>

    suspend fun storeUserName(userName: String)
    fun getUserName(): Flow<String>

    suspend fun clearDataStore()
}
