package com.android.vaos.ux.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.android.vaos.util.navigation.HandleNavigation
import com.android.vaos.ui.theme.AppTheme
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreenContent(homeViewModel.homeUiState)
    HandleNavigation(viewModelNav = homeViewModel, navController = navController)
}

@Composable
fun HomeScreenContent(
    state: HomeUiState
) {
    val scope = rememberCoroutineScope()
    val isLoading by state.isLoading.collectAsState()
    val isAGuest by state.isAGuest.collectAsState()
    val userData by state.userData.collectAsState()

    Scaffold() { paddingValues ->
    }
}

@Preview(
    showBackground = true,
    name = "HomeScreen guest user"
)
@Composable
fun HomeScreenGuestUserPreview() {
    val isLoading = MutableStateFlow(false)
    val isAGuest: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val userData = MutableStateFlow(null)
    val state = HomeUiState(
        isLoading = isLoading,
        isAGuest = isAGuest,
        userData = userData
    )

    AppTheme {
        HomeScreenContent(
            state = state
        )
    }
}
