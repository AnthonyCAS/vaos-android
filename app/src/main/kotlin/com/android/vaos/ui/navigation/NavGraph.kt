package com.android.vaos.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.android.vaos.ux.home.HomeRoute
import com.android.vaos.ux.home.HomeScreen
import com.android.vaos.ux.starter.StarterRoute
import com.android.vaos.ux.starter.StarterScreen
import com.android.vaos.ux.welcome.WelcomeRoute
import com.android.vaos.ux.welcome.WelcomeScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        StarterRoute.addNavigationRoute(this) {
            StarterScreen(navController)
        }
        WelcomeRoute.addNavigationRoute(this) {
            WelcomeScreen(navController)
        }
        HomeRoute.addNavigationRoute(this) {
            HomeScreen(navController)
        }
    }
}
