package ru.izhxx.deliveryapp.domain.pojo

data class FoodItem(
    val id: Int,
    val name: String,
    val ingredients: String,
    val description: String,
    val minimalPrice: Int,
    val maximumPrice: Int,
    val selectedCategoryId: Int
)
