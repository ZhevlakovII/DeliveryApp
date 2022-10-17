package ru.izhxx.deliveryapp.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.domain.pojo.FoodItem

interface FoodItemRepo {
    fun createFoodItem(foodItem: FoodItem)

    fun deleteFoodItem(foodItem: FoodItem)

    fun getLocalFoodItems(): List<FoodItem>

    fun getRemoteFoodItems(): List<FoodItem>
}