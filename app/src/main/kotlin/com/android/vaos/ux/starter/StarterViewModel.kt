package com.android.vaos.ux.starter

import com.android.vaos.util.navigation.ViewModelNav
import com.android.vaos.util.navigation.ViewModelNavImpl
import com.android.vaos.ux.BaseViewModel
import com.android.vaos.ux.welcome.WelcomeRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StarterViewModel @Inject constructor() : BaseViewModel<Unit>(), ViewModelNav by ViewModelNavImpl() {
    val starterUiState = StarterUiState(
        isLoading = isLoading,
        navigateToWelcomeScreen = ::navigateToWelcomeScreen
    )

    private fun navigateToWelcomeScreen() {
        navigate(WelcomeRoute.createRoute())
    }
}
