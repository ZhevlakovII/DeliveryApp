package ru.izhxx.deliveryapp.data.repo

import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.data.repo.categories.FoodCategoryDataSource
import ru.izhxx.deliveryapp.domain.pojo.FoodCategory
import ru.izhxx.deliveryapp.domain.repository.FoodCategoryRepo
import javax.inject.Inject

class FoodCategoryRepoImpl @Inject constructor(
    private val foodCategoryDataSource: FoodCategoryDataSource
): FoodCategoryRepo {
    override fun createFoodCategory(foodCategory: FoodCategory) {
        foodCategoryDataSource.createFoodCategory(foodCategory = foodCategory)
    }

    override fun deleteFoodCategory(foodCategory: FoodCategory) {
        foodCategoryDataSource.deleteFoodCategory(foodCategory = foodCategory)
    }

    override fun getLocalFoodCategories(): List<FoodCategory> {
        return foodCategoryDataSource.getFoodCategories()
    }

    override fun getRemoteFoodCategories(): List<FoodCategory> {
        TODO("Not yet implemented")
    }
}