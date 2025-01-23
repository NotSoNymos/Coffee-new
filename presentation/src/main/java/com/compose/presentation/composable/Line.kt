package com.compose.presentation.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun LinedText(
    text: String,
    color: Color,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    strokeWidthOverride: Float = 0f
) {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }

    val textMeasurer = rememberTextMeasurer()

    val textLayoutResult = textMeasurer.measure(
        text = text, overflow = TextOverflow.Ellipsis
    )

    Canvas(modifier = modifier.onSizeChanged { size = it }) {

        drawText(
            textLayoutResult = textLayoutResult, topLeft = Offset(
                size.width / 2f - textLayoutResult.size.width / 2f,
                (textLayoutResult.size.height / 2).toFloat()
            ), color = Color.White
        )

        drawLine(
            Color.Red, Offset(0f, size.height / 2f), Offset(
                size.width.toFloat() / 2 - textLayoutResult.size.width, size.height / 2f
            ), if (strokeWidthOverride > 0) strokeWidthOverride else size.height.toFloat()
        )

        drawLine(
            Color.Red,
            Offset(
                size.width.toFloat() / 2 + textLayoutResult.size.width, size.height / 2f
            ),
            Offset(size.width.toFloat(), size.height / 2f),
            if (strokeWidthOverride > 0) strokeWidthOverride else size.height.toFloat()
        )
    }
}

@Preview
@Composable
private fun LinePreview() {
    LinedText(
        "123",
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp),
        color = Color.Red,
        textStyle = TextStyle(),
        strokeWidthOverride = 2f
    )
}