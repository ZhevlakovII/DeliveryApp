package ru.izhxx.deliveryapp.presenter.screens.menu

import ru.izhxx.deliveryapp.domain.pojo.Banner
import ru.izhxx.deliveryapp.domain.pojo.FoodCategory
import ru.izhxx.deliveryapp.domain.pojo.FoodItem

sealed class MenuState {
    object Loading : MenuState()
    object Error : MenuState()
    data class Display(
        val banners: List<Banner>,
        val categories: List<FoodCategory>,
        val selectedCategoryId: Int,
        val food: List<FoodItem>
        ) : MenuState()
}