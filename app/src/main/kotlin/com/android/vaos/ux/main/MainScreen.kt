package com.android.vaos.ux.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.android.vaos.util.ext.requireActivity
import com.android.vaos.util.navigation.HandleNavigation
import com.android.vaos.ui.navigation.NavGraph

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(LocalContext.current.requireActivity()),
    startDestination: String,
    navController: NavHostController,
) {
    NavGraph(navController = navController, startDestination)
    HandleNavigation(viewModelNav = viewModel, navController = navController)
}
