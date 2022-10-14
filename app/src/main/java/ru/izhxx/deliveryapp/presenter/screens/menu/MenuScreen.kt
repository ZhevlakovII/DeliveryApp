package ru.izhxx.deliveryapp.presenter.screens.menu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun MenuScreen(
    menuViewModel: MenuViewModel
) {
    val viewState = menuViewModel.state.observeAsState()

    when (val state = viewState.value) {
        MenuState.Loading -> {}
        MenuState.Error -> {}
        is MenuState.Display -> {}
        else -> throw NotImplementedError("Unknown state")
    }
    
    LaunchedEffect(key1 = viewState, block = {
        menuViewModel.changeState(MenuState.Loading)
    })
}