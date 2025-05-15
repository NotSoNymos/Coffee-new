package com.compose.presentation.composable.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.presentation.theme.CoffeeTheme

@Composable
fun ProductPageCard(data: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceAround) {
            ProductCard()
            Spacer(modifier = Modifier.width(10.dp))
            ProductCard()
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceAround) {
            ProductCard()
            Spacer(modifier = Modifier.width(10.dp))
            ProductCard()
        }
    }
}

@Preview
@Composable
private fun ProductPageCardPreview() {
    CoffeeTheme {
        ProductPageCard(data = "", modifier = Modifier.fillMaxWidth())
    }
}