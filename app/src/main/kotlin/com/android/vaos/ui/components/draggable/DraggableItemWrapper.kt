package com.android.vaos.ui.components.draggable

import androidx.compose.material.SwipeableState
import com.android.vaos.util.ZERO_INT

data class DraggableItemWrapper<T>(
    val item: T,
    val swipeAbleState: SwipeableState<Int> = SwipeableState(
        initialValue = ZERO_INT
    )
)
