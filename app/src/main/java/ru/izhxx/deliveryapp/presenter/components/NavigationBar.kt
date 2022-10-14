package ru.izhxx.deliveryapp.presenter.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.izhxx.deliveryapp.presenter.navigation.BottomNavigationItems
import ru.izhxx.deliveryapp.presenter.theme.DeliveryTypography
import ru.izhxx.deliveryapp.presenter.theme.lightTheme

@Composable
fun NavigationBar(
    navController: NavHostController,
    navItems: List<BottomNavigationItems>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    androidx.compose.material3.NavigationBar(
        containerColor = lightTheme.navigationBackgroundColor
    ) {
        navItems.forEach { item ->
            AddItem(
                screen = item,
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
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = lightTheme.actionColor,
            selectedTextColor = lightTheme.actionColor,
            unselectedIconColor = lightTheme.inactiveColor,
            unselectedTextColor = lightTheme.inactiveColor,
            indicatorColor = lightTheme.navigationBackgroundColor
        )
    )
}