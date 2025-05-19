package com.compose.presentation.composable

import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.compose.presentation.theme.Brown
import com.compose.presentation.theme.CoffeeTheme
import com.compose.presentation.theme.LightBrown

@Composable
fun NavigationBar(modifier: Modifier = Modifier) {
    val buttonCount = 4
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    var barSize by remember { mutableStateOf(IntSize.Zero) }

    var barDecoratorToMove = with(LocalDensity.current) {
        (barSize.width / buttonCount.times(2)).times(1 + selectedIndex.times(2))
    }

    val currentDecoratorOffset by animateIntOffsetAsState(
        targetValue = IntOffset(barDecoratorToMove, 0), label = "offset"
    )

    Column {
        Box(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
                .background(Brown),
            contentAlignment = Alignment.CenterStart
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .offset { currentDecoratorOffset }) {
                drawCircle(LightBrown, size.minDimension * 2.7f, Offset(0f, 170f))
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(LightBrown)
                .onGloballyPositioned {
                    barSize = it.size
                }, verticalAlignment = Alignment.CenterVertically
        ) {
            NavigationItem(
                modifier = Modifier.weight(buttonCount.toFloat()), selectedIndex == 0
            ) {
                selectedIndex = 0
            }
            NavigationItem(modifier = Modifier.weight(buttonCount.toFloat()), selectedIndex == 1){
                selectedIndex = 1
            }
            NavigationItem(modifier = Modifier.weight(buttonCount.toFloat()), selectedIndex == 2){
                selectedIndex = 2
            }
            NavigationItem(modifier = Modifier.weight(buttonCount.toFloat()), selectedIndex == 3){
                selectedIndex = 3
            }
        }
    }
}

@Preview
@Composable
private fun NavigationBarPreview() {
    CoffeeTheme {
        NavigationBar()
    }
}