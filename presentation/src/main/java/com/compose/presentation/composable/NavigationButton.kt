package com.compose.presentation.composable

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.compose.presentation.R
import com.compose.presentation.theme.Brown

@Composable
fun NavigationItem(
    modifier: Modifier = Modifier,
    iconBlockRadius: Dp = 50.dp,
    iconRadius: Dp = 25.dp,
    backgroundRadius: Float = 65f,
    backgroundColor: Color = Brown,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick, modifier = modifier.size(iconBlockRadius)
    ) {
        Icon(
            painter = painterResource(R.drawable.home),
            contentDescription = null,
            modifier = Modifier
                .size(iconRadius)
                .drawBehind {
                    drawCircle(
                        color = backgroundColor,
                        radius = backgroundRadius,
                        center = Offset(this.center.x, this.center.y)
                    )
                },
            tint = Color.White
        )
    }
}