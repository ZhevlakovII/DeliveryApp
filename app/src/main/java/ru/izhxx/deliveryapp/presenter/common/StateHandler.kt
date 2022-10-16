package ru.izhxx.deliveryapp.presenter.common

import ru.izhxx.deliveryapp.presenter.screens.menu.MenuEvent

interface StateHandler<T> {
    fun obtainState(event: MenuEvent)
    fun obtainState()
}