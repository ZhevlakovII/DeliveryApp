package ru.izhxx.deliveryapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_categories")
data class FoodCategoryEntity (
    @PrimaryKey
    val categoryId: Int,

    val categoryName: String
)