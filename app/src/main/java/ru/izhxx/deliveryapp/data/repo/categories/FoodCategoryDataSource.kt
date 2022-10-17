package ru.izhxx.deliveryapp.data.repo.categories

import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.domain.pojo.FoodCategory

interface FoodCategoryDataSource {
    fun createFoodCategory(foodCategory: FoodCategory)

    fun deleteFoodCategory(foodCategory: FoodCategory)

    fun getFoodCategories(): List<FoodCategory>
}