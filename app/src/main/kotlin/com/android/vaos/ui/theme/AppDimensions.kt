package com.android.vaos.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppDimensions(
    val spacingTiny: Dp = 4.dp,
    val spacingXSmall: Dp = 8.dp,
    val spacingSmall: Dp = 16.dp,
    val spacingMed: Dp = 24.dp,
    val spacingLarge: Dp = 32.dp,
    val spacingXLarge: Dp = 40.dp,
    val spacingXXLarge: Dp = 48.dp,
    val spacingXXXLarge: Dp = 56.dp,
    val spacingJumbo: Dp = 64.dp,
    val spacingGigantic: Dp = 72.dp,
    val spacingXGigantic: Dp = 80.dp,
    val size0: Dp = 0.dp,
    val size1: Dp = 1.dp,
    val size2: Dp = 2.dp,
    // corner radius
    val smallCornerRadius: Dp = 4.dp,
    val mediumCornerRadius: Dp = 8.dp,
    val largeCornerRadius: Dp = 16.dp,
    val xLargeCornedRadius: Dp = 40.dp,
    // elevation
    val smallElevation: Dp = 2.dp,
    val mediumElevation: Dp = 4.dp,
    // stroke
    val smallStrokeWidth: Dp = 2.dp,
    val largeStrokeWidth: Dp = 4.dp,
    // icon size
    val smallIconSize: Dp = 12.dp,
    val mediumIconSize: Dp = 18.dp,
    val largeIconSize: Dp = 24.dp,
    val xlargeIconSize: Dp = 32.dp,
    val xxLargeIconSize: Dp = 40.dp,
    // widgets
    val searchBarCornerRadius: Dp = 10.dp,
    val navBarHeight: Dp = 56.dp,
    val inputFieldHeight: Dp = 56.dp,
    val searchBarHeight: Dp = 52.dp,
    val draggableButtonSize: Dp = 62.dp
)

internal val LocalDimensions = staticCompositionLocalOf { AppDimensions() }
