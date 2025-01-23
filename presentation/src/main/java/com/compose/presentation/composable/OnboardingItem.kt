package com.compose.presentation.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.compose.data.models.OnboardingItemData
import com.compose.data.utils.Destinations
import com.compose.presentation.theme.CoffeeTheme

@SuppressLint("DiscouragedApi")
@Composable
fun OnboardingItem(
    data: OnboardingItemData,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(
                    context.resources.getIdentifier(
                        data.backgroundIdentifier, "drawable", "com.compose.presentation"
                    )
                ), contentScale = ContentScale.FillBounds
            )
            .paint(
                painter = painterResource(
                    context.resources.getIdentifier(
                        data.shaderIdentifier, "drawable", "com.compose.presentation"
                    )
                ), contentScale = ContentScale.FillBounds
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(200.dp))
        Text(
            text = data.title, style = CoffeeTheme.typography.titleLarge, textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = data.description, style = CoffeeTheme.typography.labelSmall, textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(275.dp))

        if (data.isButtonVisible) {
            EnterAnimation {
                DecoratedButton(
                    text = "Register",
                    modifier = Modifier
                        .width(300.dp)
                        .height(60.dp),
                ) {
                    navController.navigate(Destinations.Registration)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            EnterAnimation {
                DecoratedButton(
                    text = "Sign in",
                    modifier = Modifier
                        .width(300.dp)
                        .height(60.dp),
                    buttonType = DecoratedButtonType.Empty
                ) {
                    navController.navigate(Destinations.Login)
                }
            }
        }
    }
}

@Preview
@Composable
private fun ItemPreview() {
    CoffeeTheme {
        OnboardingItem(
            data = OnboardingItemData(), navController = rememberNavController()
        )
    }
}