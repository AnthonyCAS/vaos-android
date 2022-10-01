package com.android.vaos.ui.components.dialog

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.android.vaos.ui.theme.AppTheme
import kotlinx.coroutines.CoroutineScope

@Composable
fun BottomDialog(
    scope: CoroutineScope,
    modalBottomSheetState: ModalBottomSheetState,
    sheetContent: @Composable ColumnScope.(CoroutineScope) -> Unit,
    content: @Composable () -> Unit,
) {
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(
            topStart = AppTheme.dimens.spacingSmall,
            topEnd = AppTheme.dimens.spacingSmall
        ),
        sheetContentColor = Color.Transparent,
        sheetBackgroundColor = AppTheme.colors.colorWhite,
        sheetContent = { sheetContent(scope) }
    ) {
        content()
    }
}
