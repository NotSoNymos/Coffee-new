package com.compose.presentation.composable

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
import com.compose.data.models.OnboardingItemData
import com.compose.presentation.theme.CoffeeTheme

@Composable
fun OnboardingItem(
    data: OnboardingItemData, modifier: Modifier = Modifier, isLast: Boolean = false
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(
                    context.resources
                        .getIdentifier(
                            data.backgroundIdentifier, "drawable", "com.compose.presentation"
                        )
                ), contentScale = ContentScale.FillBounds
            )
            .paint(
                painter = painterResource(
                    context.resources
                        .getIdentifier(
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
        if (isLast) {
            DecoratedButton(
                "Register", modifier = Modifier
                    .width(300.dp)
                    .height(60.dp)
            ) { }
            Spacer(modifier = Modifier.height(10.dp))
            DecoratedButton(
                "Sign in", modifier = Modifier
                    .width(300.dp)
                    .height(60.dp),
                DecoratedButtonType.Empty
            ) { }
        }
    }
}

@Preview
@Composable
private fun ItemPreview() {
    OnboardingItem(OnboardingItemData(), isLast = true)
}