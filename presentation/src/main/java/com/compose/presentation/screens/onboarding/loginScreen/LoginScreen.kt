package com.compose.presentation.screens.onboarding.loginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.presentation.R
import com.compose.presentation.theme.CoffeeTheme

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.then(
            Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(R.drawable.login_background),
                    contentScale = ContentScale.FillBounds
                )
                .paint(
                    painter = painterResource(R.drawable.shader),
                    contentScale = ContentScale.FillBounds
                )
        ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Image(
            modifier = Modifier.size(55.dp),
            painter = painterResource(R.drawable.logo_small),
            contentDescription = "Coffee cup image"
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Welcome to login",
            style = CoffeeTheme.typography.titleMedium
        )
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}