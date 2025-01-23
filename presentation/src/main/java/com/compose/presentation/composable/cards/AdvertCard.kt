package com.compose.presentation.composable.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.presentation.R
import com.compose.presentation.theme.CoffeeTheme

@Composable
fun AdvertCard(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .width(350.dp)
            .height(150.dp)
            .background(CoffeeTheme.colors.background),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.fillMaxHeight()) {
            Text(
                "Get 20% Discount On your First Order!",
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                fontSize = 18.sp
            )
        }
    }
}

@Preview
@Composable
private fun AdvertCardPreview() {
    CoffeeTheme {
        AdvertCard()
    }
}