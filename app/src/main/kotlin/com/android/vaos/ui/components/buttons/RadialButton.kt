package com.android.vaos.ui.components.buttons

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.android.vaos.ui.theme.AppTheme
import com.android.vaos.util.compose.BooleanPreviewParameter

@Composable
fun RadialButton(
    isActive: Boolean,
    modifier: Modifier = Modifier,
    onSelected: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .wrapContentSize()
            .clip(CircleShape)
            .clickable {
                onSelected()
            }
    ) {
        Icon(
            modifier = Modifier
                .size(AppTheme.dimens.largeIconSize),
            imageVector = Icons.Filled.Circle,
            contentDescription = null,
            tint = if (isActive) {
                AppTheme.colors.colorPrimary4
            } else {
                AppTheme.colors.colorGray3
            }
        )
        if (isActive) {
            Icon(
                modifier = Modifier
                    .size(AppTheme.dimens.smallIconSize),
                imageVector = Icons.Filled.Circle,
                contentDescription = null,
                tint = AppTheme.colors.colorWhite
            )
        }
    }
}

@Preview(
    group = "Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true
)
@Composable
fun RadialButtonPreview(
    @PreviewParameter(BooleanPreviewParameter::class) enabled: Boolean
) {
    AppTheme {
        Surface(
            modifier = Modifier
                .background(AppTheme.colors.colorWhite)
                .size(100.dp)
        ) {
            RadialButton(
                isActive = enabled,
                onSelected = {}
            )
        }
    }
}
