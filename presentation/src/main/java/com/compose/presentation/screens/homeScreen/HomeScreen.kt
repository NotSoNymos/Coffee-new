package com.compose.presentation.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.presentation.R
import com.compose.presentation.composable.LinedText
import com.compose.presentation.theme.CoffeeTheme
import com.compose.presentation.theme.LightBrown

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(CoffeeTheme.colors.background)
            .offset(20.dp)
            .fillMaxSize()

    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.avatar),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Shahzaib",
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    fontSize = 22.sp,
                    color = Color.White
                ) //TODO
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    "Good Morning!",
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 18.sp,
                    color = Color.White
                ) //TODO
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {}, modifier = Modifier.offset(10.dp)) {
                Icon(
                    painter = painterResource(R.drawable.search_icon),
                    modifier = Modifier.size(24.dp),
                    contentDescription = null,
                    tint = Color.White
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.bell_icon),
                    modifier = Modifier.size(24.dp),
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(30.dp))
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    CoffeeTheme {
        HomeScreen()
    }
}