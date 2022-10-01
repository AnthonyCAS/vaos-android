package com.android.vaos.ux.welcome

import com.android.vaos.core.model.user.User
import com.android.vaos.util.navigation.ViewModelNav
import com.android.vaos.util.navigation.ViewModelNavImpl
import com.android.vaos.ux.BaseViewModel
import com.android.vaos.ux.home.HomeRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor() : BaseViewModel<Unit>(), ViewModelNav by ViewModelNavImpl() {

    private val userName = MutableStateFlow<String?>(null)

    private val userData: MutableStateFlow<User?> = MutableStateFlow(null)

    val starterUiState = WelcomeUiState(
        isLoading = isLoading,
        userData = userData,
        userName = userName,
        mutateUserName = ::mutateUserName,
        navigateToHome = ::navigateToHome
    )

    private fun mutateUserName(name: String?) {
        userName.update { name }
    }

    private fun navigateToHome() {
        navigate(HomeRoute.createRoute(userName.value.orEmpty()))
    }
}
