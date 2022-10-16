package ru.izhxx.deliveryapp.presenter.screens.menu

import ru.izhxx.deliveryapp.domain.pojo.FoodItem

sealed class MenuEvent {
    object EnterScreen : MenuEvent()
    data class ChangeCategory(val categoryId: Int) : MenuEvent()
}