package com.android.vaos.ux.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.android.vaos.ui.theme.AppTheme
import com.android.vaos.ui.theme.DisplayThemeType
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            val uiState = viewModel.uiState
            val theme by uiState.themeFlow.collectAsState()
            val loadingSplash by uiState.loadingSplash.collectAsState()

            splashScreen.setKeepOnScreenCondition { loadingSplash }

            val darkTheme = when (theme) {
                DisplayThemeType.SYSTEM_DEFAULT -> isSystemInDarkTheme()
                DisplayThemeType.LIGHT -> false
                DisplayThemeType.DARK -> true
                null -> isSystemInDarkTheme()
            }

            AppTheme(
                darkTheme = darkTheme,
                typography = AppTheme.toMaterialTypography()
            ) {
                val navController = rememberAnimatedNavController()
                val destination by viewModel.uiState.startDestination.collectAsState()
                if (destination.isNotEmpty()) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .statusBarsPadding()
                    ) {
                        MainScreen(
                            startDestination = destination,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
