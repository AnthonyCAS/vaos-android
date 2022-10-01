package com.android.vaos.ui.components.buttons

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.android.vaos.ui.theme.AppTheme

@Composable
fun CustomCheckBox(
    checked: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    sizeDp: Dp? = null,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    Box(
        modifier = modifier
    ) {
        Checkbox(
            modifier = Modifier
                .size(sizeDp ?: AppTheme.dimens.largeIconSize)
                .clip(CircleShape)
                .background(
                    color = AppTheme.colors.colorGray3.copy(
                        if (enabled) 1f else SEMI_TRANSPARENT_PERCENT
                    )
                ),
            checked = checked,
            onCheckedChange = { onCheckedChange(it) },
            colors = CheckboxDefaults.colors(
                checkedColor = AppTheme.colors.colorPrimary4,
                uncheckedColor = AppTheme.colors.colorGray3.copy(
                    if (enabled) 1f else SEMI_TRANSPARENT_PERCENT
                ),
                checkmarkColor = AppTheme.colors.colorWhite,
                disabledCheckedColor = AppTheme.colors.colorPrimary5.copy(
                    alpha = SEMI_TRANSPARENT_PERCENT
                ),
                disabledUncheckedColor = Color.Transparent
            ),
            enabled = enabled
        )
    }
}

@Preview(
    group = "Light",
    name = "Checkbox Disabled",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true
)
@Composable
fun CustomCheckBoxPreview() {
    AppTheme {
        Surface {
            CustomCheckBox(
                checked = true,
                enabled = false,
                onCheckedChange = {},
                modifier = Modifier
                    .padding(
                        all = AppTheme.dimens.spacingMed
                    )
            )
        }
    }
}

@Preview(
    group = "Light",
    name = "Checkbox Enabled",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true
)
@Composable
fun CustomCheckBoxPreview2() {
    AppTheme {
        Surface {
            CustomCheckBox(
                checked = true,
                enabled = true,
                onCheckedChange = {},
                modifier = Modifier
                    .padding(
                        all = AppTheme.dimens.spacingMed
                    )
            )
        }
    }
}

private const val SEMI_TRANSPARENT_PERCENT = 0.5f
