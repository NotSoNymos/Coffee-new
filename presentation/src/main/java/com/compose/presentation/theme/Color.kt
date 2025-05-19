package com.compose.presentation.theme

import android.annotation.SuppressLint
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Golden = Color(0xFFCE9760)
val LightBrown = Color(0xFFCE9760)
val Brown = Color(0xFF543A20)
val Grey = Color(0xFF16181C)
val LightGrey = Color(0xFF828282)

@Immutable
data class AppColors(
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val tertiaryBackground: Color,
    val text: Color
)

@SuppressLint("ComposeCompositionLocalUsage")
val LocalAppColors = staticCompositionLocalOf {
    AppColors(
        primaryBackground = Color.Unspecified,
        secondaryBackground = Color.Unspecified,
        tertiaryBackground = Color.Unspecified,
        text = Color.Unspecified
    )
}

val extendedColor = AppColors(
    primaryBackground = Brown,
    secondaryBackground = Golden,
    tertiaryBackground = LightBrown,
    text = Color.White
)
