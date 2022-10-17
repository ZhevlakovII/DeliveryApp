package ru.izhxx.deliveryapp.presenter.screens.menu.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    LazyColumn(
        modifier = Modifier
            .padding(top = 56.dp, bottom = 56.dp),
        content = {
            item { BannerRow(state.banners, onBannerClick) }
            stickyHeader { CategoryRow(state = state, onCategoryClick) }
            item { FoodItemsColumn(state = state, onItemClick = onItemClick) }
        }
    )

}