package ru.izhxx.deliveryapp.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.domain.pojo.FoodCategory

interface FoodCategoryRepo {
    fun createFoodCategory(foodCategory: FoodCategory)

    fun deleteFoodCategory(foodCategory: FoodCategory)

    fun getLocalFoodCategories(): Flow<List<FoodCategory>>

    fun getRemoteFoodCategories(): List<FoodCategory>
}