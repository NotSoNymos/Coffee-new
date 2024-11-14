package com.compose.presentation.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextDivider(modifier: Modifier = Modifier) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .drawBehind {
            drawLine(Color.Yellow, Offset(100f,100f), Offset(200f,200f))
        }) {

    }
}

@Preview
@Composable
private fun TextDividerPreview() {
    TextDivider()
}