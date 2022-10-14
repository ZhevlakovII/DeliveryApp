package ru.izhxx.deliveryapp.presenter.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.izhxx.deliveryapp.R
import ru.izhxx.deliveryapp.presenter.screens.menu.MenuState
import ru.izhxx.deliveryapp.presenter.theme.DeliveryTypography
import ru.izhxx.deliveryapp.presenter.theme.Shapes
import ru.izhxx.deliveryapp.presenter.theme.lightTheme

@Composable
fun CategoryRow(state: MenuState.Display, onCategoryClick: () -> Unit) {
    LazyRow(
        modifier = Modifier.padding(bottom = 32.dp),
        content = {
            state.categories.forEachIndexed { index, category ->
                val color = if (category == state.selectedCategory)
                    lightTheme.actionColor
                else
                    lightTheme.hintColor

                when (index) {
                    0 -> item {
                        CategoryButton(
                            modifier = Modifier.padding(start = 16.dp),
                            category = category,
                            textColor = color,
                            backgroundColor = color,
                            fontWeight = FontWeight.Medium,
                            onCategoryClick = onCategoryClick
                        )
                    }
                    state.categories.lastIndex -> item {
                        CategoryButton(
                            modifier = Modifier.padding(start = 8.dp, end = 16.dp),
                            category = category,
                            textColor = color,
                            onCategoryClick = onCategoryClick
                        )
                    }
                    else -> item {
                        CategoryButton(
                            modifier = Modifier.padding(start = 8.dp),
                            category = category,
                            textColor = color,
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
    category: String,
    textColor: Color,
    backgroundColor: Color = Color.White,
    fontWeight: FontWeight = FontWeight.Normal,
    onCategoryClick: () -> Unit
) {
    Button(
        modifier = modifier.height(32.dp),
        onClick = onCategoryClick,
        shape = Shapes.medium,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor.copy(alpha = 0.2f))
    ) {
        Text(
            text = category,
            style = DeliveryTypography.bodySmall,
            fontWeight = fontWeight,
            color = textColor
        )
    }
}