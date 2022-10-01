package com.android.vaos.ui.components.draggable

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.SwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.android.vaos.util.ONE_INT
import com.android.vaos.util.ZERO_FLOAT
import com.android.vaos.util.ZERO_INT

@Composable
fun DrawableRow(
    swipeAbleState: SwipeableState<Int>,
    modifier: Modifier = Modifier,
    mutableInteractionSource: MutableInteractionSource = remember {
        MutableInteractionSource()
    },
    hiddenContent: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    val squareSize = (DRAG_DIRECTIONAL_AMOUNT).dp
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(ZERO_FLOAT to ZERO_INT, sizePx to ONE_INT)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .swipeable(
                state = swipeAbleState,
                anchors = anchors,
                thresholds = { _, _ ->
                    FractionalThreshold(FRACTIONAL_THRESHOLD)
                },
                orientation = Orientation.Horizontal,
                interactionSource = mutableInteractionSource
            )
    ) {
        hiddenContent()
        content()
    }
}

const val DRAG_DIRECTIONAL_AMOUNT = -70
const val FRACTIONAL_THRESHOLD = 0.3f
