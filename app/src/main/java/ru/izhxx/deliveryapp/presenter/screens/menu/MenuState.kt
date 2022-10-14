package ru.izhxx.deliveryapp.presenter.screens.menu

import ru.izhxx.deliveryapp.presenter.screens.menu.views.Food

sealed class MenuState {
    object Loading : MenuState()
    object Error : MenuState()
    data class Display(
        val banners: List<String>,
        val categories: List<String>,
        val selectedCategory: String,
        val food: List<Food>
        ) : MenuState()
}