package ru.izhxx.deliveryapp.domain.usecase.fooditem

import ru.izhxx.deliveryapp.domain.pojo.FoodItem
import ru.izhxx.deliveryapp.domain.repository.FoodItemRepo
import javax.inject.Inject

class DeleteFoodItemUseCase @Inject constructor(private val foodItemRepo: FoodItemRepo) {
   fun invoke(foodItem: FoodItem) {
        foodItemRepo.deleteFoodItem(foodItem = foodItem)
    }
}