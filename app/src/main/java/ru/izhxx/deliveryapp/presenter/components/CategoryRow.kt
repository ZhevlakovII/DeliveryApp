package ru.izhxx.deliveryapp.presenter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.izhxx.deliveryapp.domain.pojo.FoodCategory
import ru.izhxx.deliveryapp.presenter.screens.menu.MenuState
import ru.izhxx.deliveryapp.presenter.theme.DeliveryTypography
import ru.izhxx.deliveryapp.presenter.theme.Shapes
import ru.izhxx.deliveryapp.presenter.theme.lightTheme

@Composable
fun CategoryRow(state: MenuState.Display, onCategoryClick: (Int) -> Unit) {
    LazyRow(
        modifier = Modifier.padding(bottom = 32.dp).background(lightTheme.backgroundColor),
        content = {
            state.categories.forEachIndexed { index, category ->
                val textColor = if (category.categoryId == state.selectedCategoryId)
                    lightTheme.actionColor
                else
                    lightTheme.hintColor

                val backgroundColor = if (category.categoryId == state.selectedCategoryId)
                    lightTheme.actionColor
                else
                    Color.White

                when (index) {
                    0 -> item {
                        CategoryButton(
                            modifier = Modifier.padding(start = 16.dp),
                            category = category,
                            textColor = textColor,
                            backgroundColor = backgroundColor,
                            fontWeight = FontWeight.Medium,
                            onCategoryClick = onCategoryClick
                        )
                    }
                    state.categories.lastIndex -> item {
                        CategoryButton(
                            modifier = Modifier.padding(start = 8.dp, end = 16.dp),
                            category = category,
                            textColor = textColor,
                            backgroundColor = backgroundColor,
                            onCategoryClick = onCategoryClick
                        )
                    }
                    else -> item {
                        CategoryButton(
                            modifier = Modifier.padding(start = 8.dp),
                            category = category,
                            textColor = textColor,
                            backgroundColor = backgroundColor,
                            onCategoryClick = onCategoryClick
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun CategoryButton(
    modifier: Modifier,
    category: FoodCategory,
    textColor: Color,
    backgroundColor: Color = Color.White,
    fontWeight: FontWeight = FontWeight.Normal,
    onCategoryClick: (Int) -> Unit
) {
    Button(
        modifier = modifier.height(32.dp),
        onClick =  { onCategoryClick(category.categoryId) },
        shape = Shapes.medium,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor.copy(alpha = 0.2f))
    ) {
        Text(
            text = category.categoryName,
            style = DeliveryTypography.bodySmall,
            fontWeight = fontWeight,
            color = textColor
        )
    }
}