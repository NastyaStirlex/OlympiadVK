package com.example.servicesvk.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.servicesvk.ServiceScreen

fun NavGraphBuilder.serviceNavigation(navController: NavController) {
    composable(
        route = "service" + "/{name}" + "/{description}" + "/{icon_url}" + "/{service_url}",
        arguments = listOf(
            navArgument("name") {
                type = NavType.StringType
            },
            navArgument("description") {
                type = NavType.StringType
            },
            navArgument("icon_url") {
                type = NavType.StringType
            },
            navArgument("service_url") {
                type = NavType.StringType
            }
        )
    ) {
        val name = it.arguments?.getString("name")
        val description = it.arguments?.getString("description")
        val iconUrl = it.arguments?.getString("icon_url")
        val serviceUrl = it.arguments?.getString("service_url")

        if (name != null) {
            if (description != null) {
                if (iconUrl != null) {
                    if (serviceUrl != null) {
                        ServiceScreen(
                            navController = navController,
                            name = name,
                            description = description,
                            iconUrl = iconUrl,
                            serviceUrl = serviceUrl
                        )
                    }
                }
            }
        }
    }
}