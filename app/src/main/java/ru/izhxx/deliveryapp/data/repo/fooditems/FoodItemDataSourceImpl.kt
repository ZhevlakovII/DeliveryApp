package ru.izhxx.deliveryapp.data.repo.fooditems

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import ru.izhxx.deliveryapp.data.local.db.FoodItemDao
import ru.izhxx.deliveryapp.data.mapper.FoodItemMapper
import ru.izhxx.deliveryapp.domain.pojo.FoodCategory
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

    /*
    * The method returns a fake date due to the lack of a correct api for the application
    * This changes only on develop branch
    */
    override fun getFoodItems(): List<FoodItem> {
        val foodItemsFlow = mutableListOf<FoodItem>()
            for (i in 0..8) {
                if (i < 6) {
                    foodItemsFlow.add(
                        FoodItem(
                            i,
                            "Italian Pizza",
                            "Lorem ipsum dolor sit amet",
                            "Lorem ipsum dolor sit amet",
                            200,
                            1000,
                            1
                        )
                    )
                } else {
                    foodItemsFlow.add(
                        FoodItem(
                            i,
                            "Italian Pasta",
                            "Lorem ipsum dolor sit amet",
                            "Lorem ipsum dolor sit amet",
                            150,
                            2500,
                            2
                        )
                    )
                }
            }
        return foodItemsFlow
//        val foodFlow = foodItemDao.getFoodItems()
//        return foodFlow.map { item ->
//            foodItemMapper.toItem(item)
//        }
    }
}