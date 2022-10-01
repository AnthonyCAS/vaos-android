package com.android.vaos.util.preference

import com.android.vaos.core.model.user.User

interface StoreUserSession {
    suspend operator fun invoke(
        user: User
    )
}
