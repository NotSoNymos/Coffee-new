package com.compose.presentation.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.compose.data.utils.Destinations
import com.compose.presentation.screens.onboardingScreen.beginScreen.BeginScreen
import com.compose.presentation.screens.onboardingScreen.loginScreen.LoginScreen
import com.compose.presentation.screens.onboardingScreen.presentationScreen.PresentationScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = Destinations.Onboarding.name
    ) {
        composable(Destinations.Main.name) {
            EnterAnimation {
                BeginScreen(navController = navController)
            }
        }
        composable(Destinations.Onboarding.name) {
            EnterAnimation {
                PresentationScreen(navController)
            }
        }
        composable(Destinations.Login.name) {
            EnterAnimation {
                LoginScreen()
            }
        }

        composable(Destinations.Registration.name) {
            EnterAnimation {

            }
        }
    }
}