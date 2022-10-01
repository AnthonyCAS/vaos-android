package com.android.vaos.ux.home

import com.android.vaos.core.model.user.User
import kotlinx.coroutines.flow.StateFlow

data class HomeUiState(
    val isLoading: StateFlow<Boolean>,
    val userData: StateFlow<User?>,
    val isAGuest: StateFlow<Boolean>
)
