package com.example.jetx.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetx.presentation.screens.login.LoginScreen

@Composable
fun JetXNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    // Aquí se conectará la pantalla del globo cuando la creemos
                }
            )
        }
    }
}