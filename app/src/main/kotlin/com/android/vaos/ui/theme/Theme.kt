package com.android.vaos.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Suppress("LongParameterList")
class AppColors(
    colorGray7: Color,
    colorGray6: Color,
    colorGray5: Color,
    colorGray4: Color,
    colorGray3: Color,
    colorGray2: Color,
    colorGray1: Color,
    colorWhite: Color,
    colorPrimary5: Color,
    colorPrimary4: Color,
    colorPrimary3: Color,
    colorPrimary2: Color,
    colorPrimary1: Color,
    colorSuccess5: Color,
    colorSuccess4: Color,
    colorSuccess3: Color,
    colorSuccess2: Color,
    colorSuccess1: Color,
    colorWarning5: Color,
    colorWarning4: Color,
    colorWarning3: Color,
    colorWarning2: Color,
    colorWarning1: Color,
    colorError5: Color,
    colorError4: Color,
    colorError3: Color,
    colorError2: Color,
    colorError1: Color
) {
    var colorGray7 by mutableStateOf(colorGray7)
        internal set
    var colorGray6 by mutableStateOf(colorGray6)
        internal set
    var colorGray5 by mutableStateOf(colorGray5)
        internal set
    var colorGray4 by mutableStateOf(colorGray4)
        internal set
    var colorGray3 by mutableStateOf(colorGray3)
        internal set
    var colorGray2 by mutableStateOf(colorGray2)
        internal set
    var colorGray1 by mutableStateOf(colorGray1)
        internal set
    var colorWhite by mutableStateOf(colorWhite)
        internal set
    var colorPrimary5 by mutableStateOf(colorPrimary5)
        internal set
    var colorPrimary4 by mutableStateOf(colorPrimary4)
        internal set
    var colorPrimary3 by mutableStateOf(colorPrimary3)
        internal set
    var colorPrimary2 by mutableStateOf(colorPrimary2)
        internal set
    var colorPrimary1 by mutableStateOf(colorPrimary1)
        internal set
    var colorSuccess5 by mutableStateOf(colorSuccess5)
        internal set
    var colorSuccess4 by mutableStateOf(colorSuccess4)
        internal set
    var colorSuccess3 by mutableStateOf(colorSuccess3)
        internal set
    var colorSuccess2 by mutableStateOf(colorSuccess2)
        internal set
    var colorSuccess1 by mutableStateOf(colorSuccess1)
        internal set
    var colorWarning5 by mutableStateOf(colorWarning5)
        internal set
    var colorWarning4 by mutableStateOf(colorWarning4)
        internal set
    var colorWarning3 by mutableStateOf(colorWarning3)
        internal set
    var colorWarning2 by mutableStateOf(colorWarning2)
        internal set
    var colorWarning1 by mutableStateOf(colorWarning1)
        internal set
    var colorError5 by mutableStateOf(colorError5)
        internal set
    var colorError4 by mutableStateOf(colorError4)
        internal set
    var colorError3 by mutableStateOf(colorError3)
        internal set
    var colorError2 by mutableStateOf(colorError2)
        internal set
    var colorError1 by mutableStateOf(colorError1)
        internal set

    fun toMaterialColors() = ColorScheme(
        primary = colorPrimary5,
        onPrimary = colorPrimary1,
        primaryContainer = colorWhite,
        onPrimaryContainer = colorGray5,
        inversePrimary = colorWhite,
        secondary = colorWhite,
        onSecondary = colorWhite,
        secondaryContainer = colorGray5,
        onSecondaryContainer = colorWhite,
        tertiary = colorPrimary1,
        onTertiary = colorPrimary4,
        tertiaryContainer = colorPrimary1,
        onTertiaryContainer = colorPrimary4,
        background = colorWhite,
        onBackground = colorWhite,
        surface = colorWhite,
        onSurface = colorWhite,
        surfaceVariant = colorWhite,
        onSurfaceVariant = colorWhite,
        surfaceTint = colorSuccess5,
        inverseSurface = colorWhite,
        inverseOnSurface = colorWhite,
        error = colorError4,
        onError = colorError1,
        errorContainer = colorWhite,
        onErrorContainer = colorError5,
        outline = colorGray1,
        outlineVariant = colorGray7,
        scrim = colorPrimary4
    )
}

private val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("No AppColorPalette provided")
}

object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val typography = TypographyConfiguration

    fun toMaterialTypography(): Typography = Typography()

    val dimens: AppDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current
}

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    typography: Typography = Typography(),
    dimensions: AppDimensions = AppTheme.dimens,
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) darkColors() else lightColors()
    val systemUiController = rememberSystemUiController()

    val colorPalette = remember { colors }

    systemUiController.setSystemBarsColor(
        color = Color.Transparent,
        darkIcons = !darkTheme
    )
    CompositionLocalProvider(
        LocalAppColors provides colorPalette,
        LocalDimensions provides dimensions
    ) {
        MaterialTheme(
            colorScheme = colors.toMaterialColors(),
            typography = typography,
            content = content,
        )
    }
}

fun lightColors(): AppColors {
    return AppColors(
        colorGray7 = AppPalette.colorGray7,
        colorGray6 = AppPalette.colorGray6,
        colorGray5 = AppPalette.colorGray5,
        colorGray4 = AppPalette.colorGray4,
        colorGray3 = AppPalette.colorGray3,
        colorGray2 = AppPalette.colorGray2,
        colorGray1 = AppPalette.colorGray1,
        colorWhite = AppPalette.colorWhite,
        colorPrimary5 = AppPalette.colorPrimary5,
        colorPrimary4 = AppPalette.colorPrimary4,
        colorPrimary3 = AppPalette.colorPrimary3,
        colorPrimary2 = AppPalette.colorPrimary2,
        colorPrimary1 = AppPalette.colorPrimary1,
        colorSuccess5 = AppPalette.colorSuccess5,
        colorSuccess4 = AppPalette.colorSuccess4,
        colorSuccess3 = AppPalette.colorSuccess3,
        colorSuccess2 = AppPalette.colorSuccess2,
        colorSuccess1 = AppPalette.colorSuccess1,
        colorWarning5 = AppPalette.colorWarning5,
        colorWarning4 = AppPalette.colorWarning4,
        colorWarning3 = AppPalette.colorWarning3,
        colorWarning2 = AppPalette.colorWarning2,
        colorWarning1 = AppPalette.colorWarning1,
        colorError5 = AppPalette.colorError5,
        colorError4 = AppPalette.colorError4,
        colorError3 = AppPalette.colorError3,
        colorError2 = AppPalette.colorError2,
        colorError1 = AppPalette.colorError1
    )
}

fun darkColors(): AppColors {
    return AppColors(
        colorGray7 = AppPalette.colorGray7,
        colorGray6 = AppPalette.colorGray6,
        colorGray5 = AppPalette.colorGray5,
        colorGray4 = AppPalette.colorGray4,
        colorGray3 = AppPalette.colorGray3,
        colorGray2 = AppPalette.colorGray2,
        colorGray1 = AppPalette.colorGray1,
        colorWhite = AppPalette.colorWhite,
        colorPrimary5 = AppPalette.colorPrimary5,
        colorPrimary4 = AppPalette.colorPrimary4,
        colorPrimary3 = AppPalette.colorPrimary3,
        colorPrimary2 = AppPalette.colorPrimary2,
        colorPrimary1 = AppPalette.colorPrimary1,
        colorSuccess5 = AppPalette.colorSuccess5,
        colorSuccess4 = AppPalette.colorSuccess4,
        colorSuccess3 = AppPalette.colorSuccess3,
        colorSuccess2 = AppPalette.colorSuccess2,
        colorSuccess1 = AppPalette.colorSuccess1,
        colorWarning5 = AppPalette.colorWarning5,
        colorWarning4 = AppPalette.colorWarning4,
        colorWarning3 = AppPalette.colorWarning3,
        colorWarning2 = AppPalette.colorWarning2,
        colorWarning1 = AppPalette.colorWarning1,
        colorError5 = AppPalette.colorError5,
        colorError4 = AppPalette.colorError4,
        colorError3 = AppPalette.colorError3,
        colorError2 = AppPalette.colorError2,
        colorError1 = AppPalette.colorError1
    )
}
