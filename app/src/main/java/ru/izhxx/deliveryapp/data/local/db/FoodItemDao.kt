package ru.izhxx.deliveryapp.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.data.local.entities.FoodItemEntity
import ru.izhxx.deliveryapp.domain.pojo.FoodItem

@Dao
interface FoodItemDao {
    @Query("SELECT * FROM food_items")
    fun getFoodItems(): List<FoodItemEntity>

    @Insert
    fun createFoodItem(foodItem: FoodItemEntity)

    @Delete
    fun deleteFoodItem(foodItem: FoodItemEntity)
}