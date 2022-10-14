package ru.izhxx.deliveryapp.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RootNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destinations.Menu) {
        composable(Destinations.Menu) {
            TODO("Main screen init")
        }
        composable(Destinations.Profile) {
            TODO("Profile screen init")
        }
        composable(Destinations.Cart) {
            TODO("Cart screen init")
        }
    }
}