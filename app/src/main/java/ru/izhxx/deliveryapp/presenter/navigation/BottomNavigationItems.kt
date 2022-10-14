package ru.izhxx.deliveryapp.presenter.navigation

import ru.izhxx.deliveryapp.R

sealed class BottomNavigationItems(
    val route: String,
    val labelResId: Int,
    val iconResId: Int,
    val descriptionResId: Int
) {
    object Menu : BottomNavigationItems(
        route = Destinations.Menu,
        labelResId = R.string.menu_label,
        iconResId = R.drawable.food_icon,
        descriptionResId = R.string.menu_description
    )
    object Profile : BottomNavigationItems(
        route = Destinations.Profile,
        labelResId = R.string.profile_label,
        iconResId = R.drawable.profile_icon,
        descriptionResId = R.string.profile_description
    )
    object Cart : BottomNavigationItems(
        route = Destinations.Cart,
        labelResId = R.string.cart_label,
        iconResId = R.drawable.cart_icon,
        descriptionResId = R.string.cart_description
    )
}