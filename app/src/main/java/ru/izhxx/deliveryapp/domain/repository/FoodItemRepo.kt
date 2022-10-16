package ru.izhxx.deliveryapp.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.domain.pojo.FoodItem

interface FoodItemRepo {
    fun createFoodItem(foodItem: FoodItem)

    fun deleteFoodItem(foodItem: FoodItem)

    fun getLocalFoodItems(): Flow<List<FoodItem>>

    fun getRemoteFoodItems(): List<FoodItem>
}