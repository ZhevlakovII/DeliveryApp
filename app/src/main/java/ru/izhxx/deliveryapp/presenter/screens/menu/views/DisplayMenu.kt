package ru.izhxx.deliveryapp.presenter.screens.menu.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import ru.izhxx.deliveryapp.presenter.components.BannerRow
import ru.izhxx.deliveryapp.presenter.components.CategoryRow
import ru.izhxx.deliveryapp.presenter.components.FoodItemsColumn
import ru.izhxx.deliveryapp.presenter.screens.menu.MenuState

@Composable
fun Display(
    onBannerClick: () -> Unit,
    onCategoryClick: () -> Unit,
    onItemClick: () -> Unit,
    state: MenuState.Display
) {
    val lazyColumnState: LazyListState = rememberLazyListState()

    LazyColumn(
        state = lazyColumnState,
        content = {
            item {
                BannerRow(state.banners, onBannerClick)
                CategoryRow(state = state, onCategoryClick)
                FoodItemsColumn(state = state, onItemClick = onItemClick)
            }
        }
    )
    
}