package ru.izhxx.deliveryapp.domain.usecase.categories

import ru.izhxx.deliveryapp.domain.pojo.FoodCategory
import ru.izhxx.deliveryapp.domain.repository.FoodCategoryRepo
import javax.inject.Inject

class DeleteFoodCategoryUseCase @Inject constructor(private val foodCategoryRepo: FoodCategoryRepo)  {
    fun invoke(foodCategory: FoodCategory) {
        foodCategoryRepo.deleteFoodCategory(foodCategory = foodCategory)
    }
}