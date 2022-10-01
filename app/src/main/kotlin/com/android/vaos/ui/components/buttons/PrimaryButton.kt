package com.android.vaos.ui.components.buttons

import android.content.res.Configuration
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MotionPhotosOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.android.vaos.util.compose.BooleanPreviewParameter
import com.android.vaos.ui.theme.AppTheme

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = AppTheme.colors.colorPrimary4,
        contentColor = AppTheme.colors.colorWhite,
        disabledContainerColor = AppTheme.colors.colorPrimary3,
        disabledContentColor = AppTheme.colors.colorWhite
    ),
    contentPadding: PaddingValues = PaddingValues(
        vertical = AppTheme.dimens.spacingXSmall,
        horizontal = AppTheme.dimens.spacingSmall
    ),
    contentCustom: (@Composable RowScope.() -> Unit)? = null
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .then(modifier),
        colors = colors,
        enabled = enabled,
        contentPadding = contentPadding,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = AppTheme.dimens.mediumElevation,
            disabledElevation = AppTheme.dimens.size0
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            when {
                contentCustom != null -> {
                    contentCustom()
                }
                isLoading -> {
                    val infiniteTransition = rememberInfiniteTransition()
                    val angle by infiniteTransition.animateFloat(
                        initialValue = ANIMATION_BEGIN_POSITION,
                        targetValue = ANIMATION_END_POSITION,
                        animationSpec = infiniteRepeatable(
                            animation = tween(
                                ANIMATION_DURATION,
                                easing = LinearEasing
                            )
                        )
                    )
                    Icon(
                        imageVector = Icons.Outlined.MotionPhotosOn,
                        contentDescription = null,
                        tint = AppTheme.colors.colorWhite,
                        modifier = Modifier.graphicsLayer {
                            rotationZ = angle
                        }
                    )
                }
                else -> {
                    Text(
                        text = text,
                        style = AppTheme.typography.bodyLRegular,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Preview(
    group = "Light",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true
)
@Composable
fun PrimaryButtonPreview(
    @PreviewParameter(BooleanPreviewParameter::class) enabled: Boolean
) {
    AppTheme {
        PrimaryButton(
            text = "Verify",
            onClick = {},
            enabled = enabled,
            isLoading = false,
            modifier = Modifier
                .wrapContentHeight()
                .padding(
                    all = AppTheme.dimens.spacingMed
                )
        )
    }
}

@Preview
@Composable
fun PrimaryButtonLoadingPreview(
    @PreviewParameter(BooleanPreviewParameter::class) enabled: Boolean
) {
    AppTheme {
        PrimaryButton(
            text = "Verify",
            onClick = {},
            enabled = enabled,
            isLoading = true,
            modifier = Modifier
                .wrapContentHeight()
                .padding(
                    all = AppTheme.dimens.spacingMed
                )
        )
    }
}

private const val ANIMATION_BEGIN_POSITION = 0F
private const val ANIMATION_END_POSITION = 360F
private const val ANIMATION_DURATION = 2000
