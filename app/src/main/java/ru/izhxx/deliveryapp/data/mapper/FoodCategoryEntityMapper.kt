package ru.izhxx.deliveryapp.data.mapper

import ru.izhxx.deliveryapp.data.local.entities.FoodCategoryEntity
import ru.izhxx.deliveryapp.domain.pojo.FoodCategory

class FoodCategoryEntityMapper {
    fun toEntity(foodCategory: FoodCategory): FoodCategoryEntity {
        return FoodCategoryEntity(
            categoryId = foodCategory.categoryId,
            categoryName = foodCategory.categoryName
        )
    }

    fun toItem(foodCategoryEntity: FoodCategoryEntity): FoodCategory {
        return FoodCategory(
            categoryId = foodCategoryEntity.categoryId,
            categoryName = foodCategoryEntity.categoryName
        )
    }
}