package ru.izhxx.deliveryapp.presenter.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.izhxx.deliveryapp.presenter.navigation.BottomNavigationItems
import ru.izhxx.deliveryapp.presenter.navigation.RootNavigation
import ru.izhxx.deliveryapp.presenter.theme.DeliveryTypography

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navigationItems = listOf(
        BottomNavigationItems.Menu,
        BottomNavigationItems.Profile,
        BottomNavigationItems.Cart
    )

    Scaffold(bottomBar = { NavigationBar(navController, navigationItems) }) {
        RootNavigation(navController = navController)
    }
}

@Composable
fun NavigationBar(
    navController: NavHostController,
    navItems: List<BottomNavigationItems>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        navItems.forEach { item ->
            AddItem(screen = item,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavigationItems,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        label = {
            Text(
                text = stringResource(id = screen.labelResId),
                style = DeliveryTypography.labelSmall
            )
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.iconResId),
                contentDescription = stringResource(id = screen.descriptionResId)
            )
        }
    )
}

@Preview
@Composable
fun PreviewBottom() {
    MainScreen()
}