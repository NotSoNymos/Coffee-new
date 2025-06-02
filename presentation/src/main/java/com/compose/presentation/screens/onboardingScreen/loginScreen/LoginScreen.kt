package com.compose.presentation.screens.onboardingScreen.loginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.compose.presentation.composable.DecoratedButton
import com.compose.presentation.composable.InputField
import com.compose.presentation.composable.InputFieldOptions
import com.compose.presentation.composable.LinedText
import com.compose.presentation.theme.CoffeeTheme
import com.compose.presentation.theme.LightBrown

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = modifier.then(
                Modifier
                    .fillMaxSize()
                    .paint(
                        painter = painterResource(R.drawable.login_background),
                        contentScale = ContentScale.FillBounds
                    )
                    .paint(
                        painter = painterResource(R.drawable.second_shader),
                        contentScale = ContentScale.FillBounds
                    )
                    .padding(start = 20.dp, end = 20.dp)
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
            Spacer(modifier = Modifier.height(50.dp))
            InputField(
                options = InputFieldOptions(),
                modifier = Modifier.height(60.dp),
                placeholder = "Full Name",
                onValueChange = {}//viewModel::setName
            )
            Spacer(modifier = Modifier.height(12.dp))
            InputField(
                options = InputFieldOptions(),
                modifier = Modifier.height(60.dp),
                placeholder = "E-mail Address",
                onValueChange = {}//viewModel::setName
            )
            Spacer(modifier = Modifier.height(12.dp))
            InputField(
                options = InputFieldOptions(),
                modifier = Modifier.height(60.dp),
                placeholder = "Password",
                onValueChange = {}//viewModel::setName
            )
            Spacer(modifier = Modifier.height(12.dp))
            InputField(
                options = InputFieldOptions(),
                modifier = Modifier.height(60.dp),
                placeholder = "Confirm Password",
                onValueChange = {}//viewModel::setName
            )
            Spacer(modifier = Modifier.height(30.dp))
            DecoratedButton(
                text = "Register", modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {

            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        LinedText(
            "Or Login with",
            color = LightBrown,
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
            strokeWidthOverride = 2f
        )
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    CoffeeTheme {
        LoginScreen()
    }
}