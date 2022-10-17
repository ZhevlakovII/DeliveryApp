package ru.izhxx.deliveryapp.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.data.local.entities.FoodCategoryEntity
import ru.izhxx.deliveryapp.domain.pojo.FoodCategory

@Dao
interface FoodCategoryDao {
    @Query("SELECT * FROM food_categories")
    fun getFoodCategories(): List<FoodCategoryEntity>

    @Insert
    fun createFoodCategory(foodCategory: FoodCategoryEntity)

    @Delete
    fun deleteFoodCategory(foodCategory: FoodCategoryEntity)
}