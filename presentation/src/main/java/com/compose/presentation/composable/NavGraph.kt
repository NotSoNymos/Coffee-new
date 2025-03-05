package com.compose.presentation.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.compose.data.utils.Destinations
import com.compose.presentation.screens.homeScreen.HomeScreen
import com.compose.presentation.screens.onboardingScreen.beginScreen.BeginScreen
import com.compose.presentation.screens.onboardingScreen.loginScreen.LoginScreen
import com.compose.presentation.screens.onboardingScreen.presentationScreen.PresentationScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = Destinations.Main
    ) {
        composable<Destinations.Main>{
            HomeScreen()
        }
    }
}