package ru.izhxx.deliveryapp.data.repo.fooditems

import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.domain.pojo.FoodItem

interface FoodItemDataSource {
    fun createFoodItem(foodItem: FoodItem)

    fun deleteFoodItem(foodItem: FoodItem)

    fun getFoodItems(): List<FoodItem>
}