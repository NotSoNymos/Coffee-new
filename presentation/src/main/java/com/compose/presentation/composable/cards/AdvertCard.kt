package com.compose.presentation.composable.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
        modifier = modifier
            .width(350.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(CoffeeTheme.colors.secondaryBackground.copy(alpha = 0.5f))
            .padding(start = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(3f)
                .padding(top = 25.dp)
                .fillMaxSize()
        ) {
            Text(
                "Get 20% Discount On your First Order!",
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                fontSize = 18.sp,
                color = Color.White,
                lineHeight = 26.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "Lorem ipsum dolor sit amet consectetur. Vestibulum eget blandit mattis ",
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                lineHeight = 12.sp,
                fontSize = 8.sp,
                color = Color.White
            )
        }
        Image(
            painter = painterResource(R.drawable.coffee_adv),
            modifier = Modifier.weight(2f).height(150.dp).width(160.dp),
            contentDescription = null
        )

    }
}

@Preview
@Composable
private fun AdvertCardPreview() {
    CoffeeTheme {
        AdvertCard()
    }
}