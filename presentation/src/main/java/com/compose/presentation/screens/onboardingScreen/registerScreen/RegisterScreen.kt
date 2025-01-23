package com.compose.presentation.screens.onboardingScreen.registerScreen

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
import com.compose.presentation.theme.CoffeeTheme

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
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
            text = "Register your Account",
            style = CoffeeTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(50.dp))
        InputField(value = "Full Name", options = InputFieldOptions(), modifier = Modifier.height(60.dp)) {

        }
        Spacer(modifier = Modifier.height(12.dp))
        InputField(value = "E-mail Address", options = InputFieldOptions(), modifier = Modifier.height(60.dp)) {

        }
        Spacer(modifier = Modifier.height(12.dp))
        InputField(value = "Password", options = InputFieldOptions(), modifier = Modifier.height(60.dp)) {

        }
        Spacer(modifier = Modifier.height(12.dp))
        InputField(value = "Confirm Password", options = InputFieldOptions(), modifier = Modifier.height(60.dp)) {

        }
        Spacer(modifier = Modifier.height(30.dp))
        DecoratedButton(text = "Register", modifier = Modifier.fillMaxWidth().height(60.dp)) {

        }
        Spacer(modifier = Modifier.height(15.dp))
        
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    CoffeeTheme {
        RegisterScreen()
    }
}