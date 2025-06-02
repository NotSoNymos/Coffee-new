package com.compose.presentation.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.compose.data.utils.Destinations
import com.compose.presentation.screens.catalogScreen.CatalogScreen
import com.compose.presentation.screens.onboardingScreen.loginScreen.LoginScreen
import com.compose.presentation.screens.onboardingScreen.registerScreen.RegisterScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier, navController: NavHostController, skipAuth: Boolean = false) {
    NavHost(
        navController = navController, startDestination = if (skipAuth) Destinations.Main else Destinations.Register
    ) {
        composable<Destinations.Login> {
            LoginScreen()
        }
        composable<Destinations.Register> {
            RegisterScreen()
        }
        composable<Destinations.Main>{
            CatalogScreen()
        }
    }
}