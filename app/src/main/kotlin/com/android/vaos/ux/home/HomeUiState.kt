package com.android.vaos.ux.home

import kotlinx.coroutines.flow.StateFlow

data class HomeUiState(
    val isLoading: StateFlow<Boolean>,
    val userName: StateFlow<String>
)
