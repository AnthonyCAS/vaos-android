package com.android.vaos.ux.main

import com.android.vaos.ui.theme.DisplayThemeType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class MainUiState(
    val startDestination: StateFlow<String>,
    val themeFlow: StateFlow<DisplayThemeType?> = MutableStateFlow(null),
    val loadingSplash: StateFlow<Boolean>
)
