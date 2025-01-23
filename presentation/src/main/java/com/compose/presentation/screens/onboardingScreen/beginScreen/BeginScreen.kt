package com.compose.presentation.screens.onboardingScreen.beginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.compose.data.utils.Destinations
import com.compose.presentation.R
import com.compose.presentation.composable.DecoratedButton
import com.compose.presentation.theme.CoffeeTheme

@Composable
fun BeginScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.coffee_background),
                contentScale = ContentScale.FillBounds
            )
            .paint(
                painter = painterResource(R.drawable.shader),
                contentScale = ContentScale.FillBounds
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(200.dp))
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Coffee cup image"
        )
        Spacer(modifier = Modifier.height(335.dp))
        DecoratedButton(
            text = "Get Started",
            modifier = Modifier
                .height(60.dp)
                .width(300.dp)
        ) {
            navController.navigate(Destinations.Onboarding)
        }
    }
}

@Preview
@Composable
private fun BeginScreenPreview() {
    CoffeeTheme {
        BeginScreen(rememberNavController())
    }
}