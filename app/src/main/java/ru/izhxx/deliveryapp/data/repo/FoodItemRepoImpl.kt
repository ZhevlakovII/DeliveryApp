package ru.izhxx.deliveryapp.data.repo

import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.data.repo.fooditems.FoodItemDataSource
import ru.izhxx.deliveryapp.domain.pojo.FoodItem
import ru.izhxx.deliveryapp.domain.repository.FoodItemRepo
import javax.inject.Inject

class FoodItemRepoImpl @Inject constructor(
    private val foodItemDataSource: FoodItemDataSource
) : FoodItemRepo {
    override fun createFoodItem(foodItem: FoodItem) {
        foodItemDataSource.createFoodItem(foodItem = foodItem)
    }

    override fun deleteFoodItem(foodItem: FoodItem) {
        foodItemDataSource.deleteFoodItem(foodItem = foodItem)
    }

    override fun getLocalFoodItems(): Flow<List<FoodItem>> {
        return foodItemDataSource.getFoodItems()
    }

    override fun getRemoteFoodItems(): List<FoodItem> {
        TODO("Not yet implemented")
    }
}