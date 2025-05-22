package com.compose.presentation.screens

import android.os.Bundle
import android.view.WindowInsets
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.compose.data.utils.Destinations
import com.compose.presentation.composable.NavGraph
import com.compose.presentation.composable.NavigationBar
import com.compose.presentation.screens.splashScreen.SplashScreenViewModel
import com.compose.presentation.theme.CoffeeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<SplashScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        actionBar?.hide()
        window.insetsController?.hide(WindowInsets.Type.statusBars())
        viewModel.checkLogin().apply {
            setContent {
                CoffeeTheme {
                    val state = viewModel.state.collectAsState().value
                    val navController = rememberNavController()

                    var isBottomBarShouldBeShown = remember {
                        mutableStateOf(
                            Destinations.isBottomBarShouldBeShown(navController.currentDestination?.route.toString().substringAfterLast("."))
                        )
                    }

                    navController.addOnDestinationChangedListener { navController, navDestination, bundle ->
                        isBottomBarShouldBeShown.value = Destinations.isBottomBarShouldBeShown(
                            navController.currentDestination?.route.toString().substringAfterLast(".")
                        )
                    }
                    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                        if (isBottomBarShouldBeShown.value) {
                            NavigationBar()
                        }
                    }) { innerPadding ->
                        NavGraph(
                            navController = navController,
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize(),
                            skipAuth = state.skipAuth
                        )
                    }
                }
            }
        }
    }
}