package ru.izhxx.deliveryapp.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.izhxx.deliveryapp.presenter.screens.main.MainScreen
import ru.izhxx.deliveryapp.presenter.screens.cart.CartScreen
import ru.izhxx.deliveryapp.presenter.screens.menu.MenuScreen
import ru.izhxx.deliveryapp.presenter.screens.menu.MenuViewModel
import ru.izhxx.deliveryapp.presenter.screens.profile.ProfileScreen

@Composable
fun RootNavigation(navController: NavHostController) {
    val menuViewModel = hiltViewModel<MenuViewModel>()
    NavHost(navController = navController, startDestination = Destinations.Menu) {
        composable(Destinations.Menu) {
            MenuScreen(menuViewModel = menuViewModel)
        }
        composable(Destinations.Profile) {
            ProfileScreen()
        }
        composable(Destinations.Cart) {
            CartScreen()
        }
    }
}