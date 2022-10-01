package com.android.vaos.ux.main

import androidx.lifecycle.viewModelScope
import com.android.vaos.util.navigation.ViewModelNav
import com.android.vaos.util.navigation.ViewModelNavImpl
import com.android.vaos.ui.theme.DisplayThemeType
import com.android.vaos.ux.BaseViewModel
import com.android.vaos.ux.home.HomeRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel<Unit>(), ViewModelNav by ViewModelNavImpl() {

    private val startDestination: MutableStateFlow<String> = MutableStateFlow(
        HomeRoute.routeDefinition
    )

    private val loadingSplash = MutableStateFlow(true)

    init {
        loadingSplashScreen()
    }

    private fun loadingSplashScreen() = launchIO {
        delay(SPLASH_DURATION)
        loadingSplash.update { false }
    }

    private val themeConfigurationFlow = flowOf(DisplayThemeType.LIGHT)

    val uiState = MainUiState(
        startDestination = startDestination,
        themeFlow = themeConfigurationFlow.stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            DisplayThemeType.SYSTEM_DEFAULT
        ),
        loadingSplash = loadingSplash
    )

    companion object {
        private const val SPLASH_DURATION = 2000L
    }
}
