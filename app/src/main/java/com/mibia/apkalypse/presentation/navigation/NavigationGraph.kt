package com.mibia.apkalypse.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mibia.apkalypse.presentation.PlaceholderScreen
import com.mibia.apkalypse.presentation.home.HomeScreen

@Composable
fun NavigationGraph(
    navController : NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = Home){
        composable<Home>{
            //placeholder na DI z homescreen
            HomeScreen(
                onFeaturePicked = {
                    //placeholder na demo nawigacji
                    navController.navigate(Placeholder)
                }
            )
        }
        composable<Placeholder> {
            PlaceholderScreen()
        }
    }
}