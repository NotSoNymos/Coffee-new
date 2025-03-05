package com.compose.presentation.screens.onboardingScreen.presentationScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.compose.data.utils.Constants
import com.compose.presentation.composable.CustomShape
import com.compose.presentation.composable.OnboardingItem
import com.compose.presentation.theme.CoffeeTheme
import com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic
import com.tbuonomo.viewpagerdotsindicator.compose.type.WormIndicatorType

@Composable
fun PresentationScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(pageCount = {
        3
    })
    val data = Constants.OnboardingItems
    Box {
        HorizontalPager(state = pagerState, pageSpacing = 20.dp) { page ->
            OnboardingItem(
                data = data[page],
                navController = navController
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .offset(x = (-10).dp, y = 20.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            DotsIndicator(
                dotSpacing = 20.dp,
                dotCount = pagerState.pageCount,
                type = WormIndicatorType(
                    dotsGraphic = DotGraphic(
                        color = Color.White,
                        shape = CustomShape, size = 15.dp
                    ), wormDotGraphic = DotGraphic(
                        color = CoffeeTheme.colors.secondaryBackground,
                        shape = CustomShape, size = 15.dp
                    )
                ),
                pagerState = pagerState,
                modifier = Modifier
                    .height(50.dp)
                    .width(150.dp)
            )
        }
    }
}

@Preview
@Composable
private fun PresentationScreenPreview() {
    CoffeeTheme {
        PresentationScreen(rememberNavController())
    }
}