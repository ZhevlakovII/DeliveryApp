package ru.izhxx.deliveryapp.presenter.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.izhxx.deliveryapp.R
import ru.izhxx.deliveryapp.domain.pojo.FoodItem
import ru.izhxx.deliveryapp.presenter.screens.menu.MenuState
import ru.izhxx.deliveryapp.presenter.theme.DeliveryTypography
import ru.izhxx.deliveryapp.presenter.theme.Shapes
import ru.izhxx.deliveryapp.presenter.theme.lightTheme

@Composable
fun FoodItemsColumn(state: MenuState.Display, onItemClick: (FoodItem) -> Unit) {
    LazyColumn(userScrollEnabled = true, modifier = Modifier.height(780.dp)) {
        state.food.forEachIndexed { index, food ->
            when (index) {
                state.food.lastIndex -> item {
                    FoodButtonRow(
                        food = food,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        onItemClick = onItemClick
                    )
                }
                else -> item {
                    FoodButtonRow(
                        food = food,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 32.dp),
                        onItemClick = onItemClick
                    )
                }
            }
        }
    }
}

@Composable
fun FoodButtonRow(food: FoodItem, modifier: Modifier, onItemClick: (FoodItem) -> Unit) {
    Row(horizontalArrangement = Arrangement.Start, modifier = modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier
                .size(136.dp)
                .padding(end = 22.dp),
            painter = painterResource(id = R.drawable.discount_banner),
            contentDescription = "Food Image"
        )

        Spacer(modifier = Modifier.weight(weight = 1f, fill = true))

        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = food.name,
                style = DeliveryTypography.headlineMedium,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.Start)
            )
            Text(
                text = food.ingredients,
                style = DeliveryTypography.bodyMedium,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .align(Alignment.Start)
                    .fillMaxWidth(),
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )
            OutlinedButton(
                onClick = { onItemClick(food) },
                border = BorderStroke(width = 1.dp, color = lightTheme.actionColor),
                modifier = Modifier
                    .height(32.dp)
                    .align(Alignment.End),
                shape = Shapes.medium
            ) {
                Text(
                    text = String.format("From ${food.minimalPrice}"),
                    style = DeliveryTypography.bodySmall,
                    color = lightTheme.actionColor
                )
            }
        }
    }
}