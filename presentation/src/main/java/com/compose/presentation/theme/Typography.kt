package com.compose.presentation.theme

import android.annotation.SuppressLint
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.compose.presentation.R


private val UnboundedFontFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.poppins_semibold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold, FontStyle.Normal)
)

@Immutable
data class AppTypography(
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,
    val displayLarge: TextStyle,
    val displayMedium: TextStyle,
    val displaySmall: TextStyle,
    val labelLarge: TextStyle,
    val labelMedium: TextStyle,
    val labelSmall: TextStyle,
)

@SuppressLint("ComposeCompositionLocalUsage")
val LocalAppTypography = staticCompositionLocalOf {
    AppTypography(
        titleLarge = TextStyle.Default,
        titleMedium = TextStyle.Default,
        titleSmall = TextStyle.Default,
        displayLarge = TextStyle.Default,
        displayMedium = TextStyle.Default,
        displaySmall = TextStyle.Default,
        labelLarge = TextStyle.Default,
        labelMedium = TextStyle.Default,
        labelSmall = TextStyle.Default
    )
}

val extendedTypography = AppTypography(
    displayLarge = TextStyle(),
    displayMedium = TextStyle(
        fontFamily = UnboundedFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = Brown
    ),
    displaySmall = TextStyle(
        fontFamily = UnboundedFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.7.sp,
        color = LightGrey
    ),
    titleLarge = TextStyle(
        fontFamily = UnboundedFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 38.sp,
        lineHeight = 38.sp,
        letterSpacing = 0.sp,
        color = Color.White
    ),
    titleMedium = TextStyle(
        fontFamily = UnboundedFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 26.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.sp,
        color = Color.White
    ),
    titleSmall = TextStyle(),
    labelLarge = TextStyle(),
    labelMedium = TextStyle(),
    labelSmall = TextStyle(
        fontFamily = UnboundedFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.7.sp,
        color = Golden
    ),

    )