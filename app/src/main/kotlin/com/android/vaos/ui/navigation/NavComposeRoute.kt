package com.android.vaos.ui.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable

abstract class NavComposeRoute {

    abstract val routeDefinition: String

    abstract fun getArguments(): List<NamedNavArgument>

    open fun getDeepLinks(): List<NavDeepLink> = emptyList()

    @OptIn(ExperimentalAnimationApi::class)
    fun addNavigationRoute(
        navGraphBuilder: NavGraphBuilder,
        enterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition?)? = null,
        exitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition?)? = null,
        popEnterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition?)? = enterTransition,
        popExitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition?)? = exitTransition,
        content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
    ) {
        navGraphBuilder.apply {
            composable(
                route = routeDefinition,
                arguments = getArguments(),
                deepLinks = getDeepLinks(),
                enterTransition = enterTransition,
                exitTransition = exitTransition,
                popEnterTransition = popEnterTransition,
                popExitTransition = popExitTransition,
                content = content
            )
        }
    }
}

abstract class SimpleNavComposeRoute(
    override val routeDefinition: String
) : NavComposeRoute() {

    fun createRoute(): String = routeDefinition

    override fun getArguments(): List<NamedNavArgument> = emptyList()

    override fun getDeepLinks(): List<NavDeepLink> = emptyList()
}
