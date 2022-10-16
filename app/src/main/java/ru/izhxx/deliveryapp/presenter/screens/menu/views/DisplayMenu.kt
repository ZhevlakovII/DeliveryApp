package ru.izhxx.deliveryapp.presenter.screens.menu.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import ru.izhxx.deliveryapp.domain.pojo.FoodItem
import ru.izhxx.deliveryapp.presenter.components.BannerRow
import ru.izhxx.deliveryapp.presenter.components.CategoryRow
import ru.izhxx.deliveryapp.presenter.components.FoodItemsColumn
import ru.izhxx.deliveryapp.presenter.screens.menu.MenuState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DisplayMenu(
    onBannerClick: (Int) -> Unit,
    onCategoryClick: (Int) -> Unit,
    onItemClick: (FoodItem) -> Unit,
    state: MenuState.Display
) {
    val lazyColumnState: LazyListState = rememberLazyListState()

    LazyColumn(
        state = lazyColumnState,
        content = {
            item {
                BannerRow(state.banners, onBannerClick)
            }
            stickyHeader {
                CategoryRow(state = state, onCategoryClick)
            }
            item {
                FoodItemsColumn(state = state, onItemClick = onItemClick)
            }
        }
    )

}