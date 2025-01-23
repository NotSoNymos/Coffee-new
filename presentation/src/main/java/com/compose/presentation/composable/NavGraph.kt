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
        navController = navController, startDestination = Destinations.Onboarding
    ) {
        composable<Destinations.Main> {
            EnterAnimation {
                BeginScreen(navController = navController)
            }
        }

        composable<Destinations.Onboarding> {
            EnterAnimation {
                PresentationScreen(navController)
            }
        }

        composable<Destinations.Login> {
            EnterAnimation {
                LoginScreen()
            }
        }

        composable<Destinations.Registration> {
            EnterAnimation {

            }
        }
    }
}