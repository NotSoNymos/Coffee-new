package com.compose.presentation.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.compose.presentation.R
import com.compose.presentation.theme.CoffeeTheme
import kotlin.math.roundToInt

@Composable
fun NavigationItem(
    modifier: Modifier = Modifier, isSelected: Boolean,
    iconBlockRadius: Dp = 50.dp,
    iconRadius: Dp = 25.dp,
    backgroundRadius: Float = 65f,
    onClick: () -> Unit
) {
    val color by animateColorAsState(
        if (isSelected) CoffeeTheme.colors.primaryBackground
        else CoffeeTheme.colors.tertiaryBackground
    )
    var decoratorToMove = with(LocalDensity.current) {
        if (isSelected) -10.dp.toPx().roundToInt() else 0
    }

    val currentItemOffset by animateIntOffsetAsState(
        targetValue = IntOffset(0, decoratorToMove), label = "offset2"
    )

    IconButton(
        onClick = onClick, modifier = modifier
            .size(iconBlockRadius)
            .offset {
                currentItemOffset
            }
    ) {
        Icon(
            painter = painterResource(R.drawable.home),
            contentDescription = null,
            modifier = Modifier
                .size(iconRadius)
                .drawBehind {
                    drawCircle(
                        color = color,
                        radius = backgroundRadius,
                        center = Offset(this.center.x, this.center.y)
                    )
                },
            tint = Color.White
        )
    }
}