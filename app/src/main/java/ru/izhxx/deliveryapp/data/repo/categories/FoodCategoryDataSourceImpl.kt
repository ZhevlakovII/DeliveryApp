package ru.izhxx.deliveryapp.data.repo.categories

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

    /*
    * The method returns a fake date due to the lack of a correct api for the application
    * This changes only on develop branch
    */
    override fun getFoodCategories(): List<FoodCategory> {
        return mutableListOf(
            FoodCategory(1, "Pizza"),
            FoodCategory(2, "Pasta"),
            FoodCategory(3, "Drinks"),
            FoodCategory(4, "Combo"),
            FoodCategory(5, "Other")
        )
//        val flowCategories = foodCategoryDao.getFoodCategories()
//        return flowCategories.map { item ->
//            foodCategoryEntityMapper.toItem(item)
//        }
    }
}