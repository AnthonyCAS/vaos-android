package com.android.vaos.util.preference

import com.android.vaos.core.model.user.User
import javax.inject.Inject

class StoreUserSessionImp @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : StoreUserSession {

    override suspend fun invoke(user: User) {
        dataStoreManager.storeUserUUID(user.userId)
        dataStoreManager.storeUserName(user.userName)
    }
}
