package com.compose.presentation.theme

import android.annotation.SuppressLint
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Golden = Color(0xFFCE9760)
val Brown = Color(0xFF543A20)
val Grey = Color(0xFF16181C)
val LightGrey = Color(0xFF828282)

@Immutable
data class AppColors(
    val primary: Color,
    val background: Color,
    val text: Color
)

@SuppressLint("ComposeCompositionLocalUsage")
val LocalAppColors = staticCompositionLocalOf {
    AppColors(
        primary = Color.Unspecified,
        background = Color.Unspecified,
        text = Color.Unspecified
    )
}

val extendedColor = AppColors(
    primary = Golden,
    background = Brown,
    text = Color.White
)
