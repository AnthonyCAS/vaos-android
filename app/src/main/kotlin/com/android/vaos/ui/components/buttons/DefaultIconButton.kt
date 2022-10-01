package com.android.vaos.ui.components.buttons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.android.vaos.util.compose.BooleanPreviewParameter
import com.android.vaos.ui.theme.AppTheme

@Composable
fun DefaultIconButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    onClick: () -> Unit,
    enabled: Boolean = true,
    contentDescription: String? = null,
    tintColor: Color = AppTheme.colors.colorPrimary4
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = tintColor
        )
    }
}

@Preview
@Composable
fun DefaultIconButtonPreview(
    @PreviewParameter(BooleanPreviewParameter::class) enabled: Boolean
) {
    AppTheme {
        DefaultIconButton(
            enabled = enabled,
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            onClick = {}
        )
    }
}
