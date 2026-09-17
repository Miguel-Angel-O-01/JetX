package com.example.jetx.presentation.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login_screen")
    object HomeSearch : Screen("home_search_screen")
    object CabinViewer : Screen("cabin_viewer_screen")
    object Payment : Screen("payment_screen")
}