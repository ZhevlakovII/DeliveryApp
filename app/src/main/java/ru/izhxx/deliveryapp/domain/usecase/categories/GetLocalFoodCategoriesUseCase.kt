package ru.izhxx.deliveryapp.domain.usecase.categories

import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.domain.pojo.FoodCategory
import ru.izhxx.deliveryapp.domain.repository.FoodCategoryRepo
import javax.inject.Inject

class GetLocalFoodCategoriesUseCase @Inject constructor(private val foodCategoryRepo: FoodCategoryRepo) {
    fun invoke(): List<FoodCategory> {
        return foodCategoryRepo.getLocalFoodCategories()
    }
}