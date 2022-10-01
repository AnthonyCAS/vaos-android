package com.android.vaos.ui.theme

import android.content.Context
import com.android.vaos.R

enum class DisplayThemeType(private val textResId: Int) {
    SYSTEM_DEFAULT(R.string.system_default),
    LIGHT(R.string.light),
    DARK(R.string.dark);

    fun getString(context: Context): String {
        return context.getText(this.textResId).toString()
    }
}
