package ru.izhxx.deliveryapp.presenter.screens.menu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import ru.izhxx.deliveryapp.presenter.screens.menu.views.DisplayMenu
import ru.izhxx.deliveryapp.presenter.screens.menu.views.ErrorMenu
import ru.izhxx.deliveryapp.presenter.screens.menu.views.LoadingMenu

@Composable
fun MenuScreen(
    menuViewModel: MenuViewModel
) {
    val viewState = menuViewModel.state.observeAsState()

    when (val state = viewState.value) {
        MenuState.Loading -> LoadingMenu()
        MenuState.Error -> ErrorMenu {
            menuViewModel.changeState(MenuState.Error)
            menuViewModel.obtainState()
        }
        is MenuState.Display -> DisplayMenu(
            onBannerClick = { /*TODO(Realize open banner)*/ },
            onCategoryClick = { category ->
                menuViewModel.obtainState(MenuEvent.ChangeCategory(category))
            },
            onItemClick = { /*TODO(Realize open food item)*/ },
            state = state
        )
        else -> throw NotImplementedError("Unknown state")
    }
    
    LaunchedEffect(key1 = viewState, block = {
        menuViewModel.changeState(MenuState.Loading)
        menuViewModel.obtainState()
    })
}