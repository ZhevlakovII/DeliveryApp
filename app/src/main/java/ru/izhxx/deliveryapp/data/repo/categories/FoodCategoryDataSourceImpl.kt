package ru.izhxx.deliveryapp.data.repo.categories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.izhxx.deliveryapp.data.local.db.FoodCategoryDao
import ru.izhxx.deliveryapp.data.mapper.FoodCategoryEntityMapper
import ru.izhxx.deliveryapp.domain.pojo.FoodCategory
import javax.inject.Inject

class FoodCategoryDataSourceImpl @Inject constructor(
    private val foodCategoryDao: FoodCategoryDao,
    private val foodCategoryEntityMapper: FoodCategoryEntityMapper
) : FoodCategoryDataSource {
    override fun createFoodCategory(foodCategory: FoodCategory) {
        foodCategoryDao.createFoodCategory(
            foodCategory = foodCategoryEntityMapper.toEntity(foodCategory
            )
        )
    }

    override fun deleteFoodCategory(foodCategory: FoodCategory) {
        foodCategoryDao.deleteFoodCategory(
            foodCategory = foodCategoryEntityMapper.toEntity(foodCategory
            )
        )
    }

    override fun getFoodCategories(): Flow<List<FoodCategory>> {
        val flowCategories = foodCategoryDao.getFoodCategories()
        return flowCategories.map { list ->
            list.map { element ->
                foodCategoryEntityMapper.toItem(element)
            }
        }
    }
}