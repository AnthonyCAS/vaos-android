package com.android.vaos.ux.welcome

import com.android.vaos.core.model.user.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class WelcomeUiState(
    val isLoading: StateFlow<Boolean>,
    val userData: StateFlow<User?>,
    val userName: StateFlow<String?>,
    val isAGuest: StateFlow<Boolean> = MutableStateFlow(false),
    val mutateUserName: (String?) -> Unit
)
