package com.android.vaos.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.android.vaos.R

object TypographyConfiguration {
    private val PoppinsFamily = FontFamily(
        Font(R.font.poppins_bold, FontWeight.Bold),
        Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
        Font(R.font.poppins_regular, FontWeight.Normal),
        Font(R.font.poppins_medium, FontWeight.Medium),
    )

    val displayLRegular = TextStyle(
        fontFamily = PoppinsFamily,
        lineHeight = 64.sp,
        fontSize = 48.sp,
        letterSpacing = 1.sp,
        fontWeight = FontWeight.Normal
    )

    val displayMRegular = TextStyle(
        fontFamily = PoppinsFamily,
        lineHeight = 32.sp,
        fontSize = 24.sp,
        letterSpacing = 1.sp,
        fontWeight = FontWeight.Normal
    )

    val displaySRegular = TextStyle(
        fontFamily = PoppinsFamily,
        lineHeight = 40.sp,
        fontSize = 32.sp,
        letterSpacing = 1.sp,
        fontWeight = FontWeight.Normal
    )

    val bodyLRegular = TextStyle(
        fontFamily = PoppinsFamily,
        lineHeight = 24.sp,
        fontSize = 16.sp,
        letterSpacing = 0.05.sp,
        fontWeight = FontWeight.Normal
    )

    val bodyMRegular = TextStyle(
        fontFamily = PoppinsFamily,
        lineHeight = 20.sp,
        fontSize = 14.sp,
        letterSpacing = 0.05.sp,
        fontWeight = FontWeight.Normal
    )

    val bodySRegular = TextStyle(
        fontFamily = PoppinsFamily,
        lineHeight = 16.sp,
        fontSize = 12.sp,
        letterSpacing = 0.05.sp,
        fontWeight = FontWeight.Normal
    )

    val bodyXSRegular = TextStyle(
        fontFamily = PoppinsFamily,
        lineHeight = 16.sp,
        fontSize = 13.sp,
        letterSpacing = 0.02.sp,
        fontWeight = FontWeight.Normal
    )
}
