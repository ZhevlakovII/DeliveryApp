package ru.izhxx.deliveryapp.data.repo.fooditems

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.izhxx.deliveryapp.data.local.db.FoodItemDao
import ru.izhxx.deliveryapp.data.mapper.FoodItemMapper
import ru.izhxx.deliveryapp.domain.pojo.FoodItem
import javax.inject.Inject

class FoodItemDataSourceImpl @Inject constructor(
    private val foodItemDao: FoodItemDao,
    private val foodItemMapper: FoodItemMapper
) : FoodItemDataSource {
    override fun createFoodItem(foodItem: FoodItem) {
        foodItemDao.createFoodItem(foodItem = foodItemMapper.toEntity(foodItem))
    }

    override fun deleteFoodItem(foodItem: FoodItem) {
        foodItemDao.deleteFoodItem(foodItem = foodItemMapper.toEntity(foodItem))
    }

    override fun getFoodItems(): Flow<List<FoodItem>> {
        val foodFlow = foodItemDao.getFoodItems()
        return foodFlow.map { list ->
            list.map { element ->
                foodItemMapper.toItem(element)
            }
        }
    }
}