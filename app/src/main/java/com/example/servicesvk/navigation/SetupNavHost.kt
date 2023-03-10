package com.example.servicesvk.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.servicesvk.MainScreen
import com.example.servicesvk.MainViewModel
import com.example.servicesvk.ServiceScreen

@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {

        composable("main") {
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(mainViewModel = mainViewModel, navController)
        }

        serviceNavigation(navController)

    }
}