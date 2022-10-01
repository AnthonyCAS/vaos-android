package com.android.vaos.ui.components.buttons

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PowerSettingsNew
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.android.vaos.ui.theme.AppTheme
import com.android.vaos.util.compose.BooleanPreviewParameter

@Composable
fun SecondaryButton(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent,
        contentColor = AppTheme.colors.colorPrimary4,
        disabledContentColor = AppTheme.colors.colorPrimary3,
        disabledContainerColor = Color.Transparent
    ),
    contentPadding: PaddingValues = PaddingValues(
        vertical = AppTheme.dimens.spacingXSmall,
        horizontal = AppTheme.dimens.spacingSmall
    )
) {
    val buttonColor = if (enabled) {
        AppTheme.colors.colorGray3
    } else {
        AppTheme.colors.colorGray3
    }
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .then(modifier),
        enabled = enabled,
        colors = colors,
        border = BorderStroke(
            width = AppTheme.dimens.smallStrokeWidth,
            color = buttonColor
        ),
        contentPadding = contentPadding
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    tint = buttonColor,
                    modifier = Modifier
                        .padding(horizontal = AppTheme.dimens.spacingSmall)
                )
            }
            Text(
                text = text,
                style = AppTheme.typography.bodyLRegular,
                color = buttonColor,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(
    group = "Light",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true
)
@Composable
fun SecondaryButtonPreview(
    @PreviewParameter(BooleanPreviewParameter::class) enabled: Boolean
) {
    AppTheme {
        SecondaryButton(
            text = "SCHEDULE",
            onClick = {},
            enabled = enabled,
            modifier = Modifier
                .wrapContentHeight()
                .padding(
                    all = AppTheme.dimens.spacingMed
                )
        )
    }
}

@Preview(
    group = "Light",
    name = "With Icon",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true
)
@Composable
fun SecondaryButtonPreview2(
    @PreviewParameter(BooleanPreviewParameter::class) enabled: Boolean
) {
    AppTheme {
        SecondaryButton(
            text = "Logout",
            onClick = {},
            enabled = enabled,
            icon = Icons.Outlined.PowerSettingsNew,
            modifier = Modifier
                .wrapContentHeight()
                .padding(
                    all = AppTheme.dimens.spacingMed
                )
        )
    }
}
