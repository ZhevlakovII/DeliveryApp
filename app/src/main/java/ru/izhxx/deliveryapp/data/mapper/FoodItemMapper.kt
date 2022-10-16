package ru.izhxx.deliveryapp.data.mapper

import ru.izhxx.deliveryapp.data.local.entities.FoodItemEntity
import ru.izhxx.deliveryapp.domain.pojo.FoodItem

class FoodItemMapper {
    fun toEntity(foodItem: FoodItem): FoodItemEntity {
        return FoodItemEntity(
            id = foodItem.id,
            name = foodItem.name,
            ingredients = foodItem.ingredients,
            description = foodItem.description,
            minimalPrice = foodItem.minimalPrice,
            maximumPrice = foodItem.maximumPrice,
            selectedCategoryId = foodItem.selectedCategoryId
        )
    }

    fun toItem(foodItemEntity: FoodItemEntity): FoodItem {
        return FoodItem(
                id = foodItemEntity.id,
                name = foodItemEntity.name,
                ingredients = foodItemEntity.ingredients,
                description = foodItemEntity.description,
                minimalPrice = foodItemEntity.minimalPrice,
                maximumPrice = foodItemEntity.maximumPrice,
                selectedCategoryId = foodItemEntity.selectedCategoryId
            )
    }
}