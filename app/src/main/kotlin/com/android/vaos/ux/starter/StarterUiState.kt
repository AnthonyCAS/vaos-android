package com.android.vaos.ux.starter

import kotlinx.coroutines.flow.StateFlow

data class StarterUiState(
    val isLoading: StateFlow<Boolean>,
    val navigateToWelcomeScreen: () -> Unit
)
