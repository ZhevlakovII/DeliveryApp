package ru.izhxx.deliveryapp.domain.usecase.fooditem

import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.domain.pojo.FoodItem
import ru.izhxx.deliveryapp.domain.repository.FoodItemRepo
import javax.inject.Inject

class GetLocalFoodItemsUseCase @Inject constructor(private val foodItemRepo: FoodItemRepo) {
    fun invoke(): Flow<List<FoodItem>> {
        return foodItemRepo.getLocalFoodItems()
    }
}