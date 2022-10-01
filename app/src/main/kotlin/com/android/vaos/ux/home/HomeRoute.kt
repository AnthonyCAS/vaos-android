package com.android.vaos.ux.home

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.android.vaos.ui.navigation.NavComposeRoute
import com.android.vaos.ui.navigation.RouteUtil
import com.android.vaos.util.EMPTY_STRING

object HomeRoute : NavComposeRoute() {

    private const val PATH = "home"

    fun createRoute(userName: String) = "$PATH?$userName"

    override val routeDefinition: String = "$PATH?${RouteUtil.defineArg(Arg.USER_NAME)}"

    override fun getArguments(): List<NamedNavArgument> {
        return listOf(
            navArgument(
                Arg.USER_NAME
            ) {
                type = NavType.StringType
                nullable = false
                defaultValue = EMPTY_STRING
            }
        )
    }

    object Arg {
        const val USER_NAME = "USER_NAME"
    }
}
