package ru.izhxx.deliveryapp.presenter.screens.main

import android.annotation.SuppressLint
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import ru.izhxx.deliveryapp.presenter.navigation.BottomNavigationItems
import ru.izhxx.deliveryapp.presenter.navigation.RootNavigation
import ru.izhxx.deliveryapp.presenter.components.NavigationBar
import ru.izhxx.deliveryapp.presenter.components.TopBar
import ru.izhxx.deliveryapp.presenter.theme.lightTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val mainViewModel = hiltViewModel<MainViewModel>()
    val navController = rememberNavController()
    val navigationItems = listOf(
        BottomNavigationItems.Menu,
        BottomNavigationItems.Profile,
        BottomNavigationItems.Cart
    )

    Scaffold(
        containerColor = lightTheme.backgroundColor,
        topBar = { TopBar(city = "Moscow") },
        bottomBar = { NavigationBar(navController, navigationItems) }
    ) {
        RootNavigation(navController = navController)
    }
}