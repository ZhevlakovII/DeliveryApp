package ru.izhxx.deliveryapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_items")
data class FoodItemEntity (
    @PrimaryKey
    val id: Int,
    val name: String,
    val ingredients: String,
    val description: String,
    val minimalPrice: Int,
    val maximumPrice: Int,
    val selectedCategoryId: Int
)