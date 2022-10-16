package ru.izhxx.deliveryapp.utils

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.izhxx.deliveryapp.data.local.db.FoodDatabase
import ru.izhxx.deliveryapp.data.local.entities.BannerEntity
import ru.izhxx.deliveryapp.data.local.entities.FoodCategoryEntity
import ru.izhxx.deliveryapp.data.local.entities.FoodItemEntity

class FoodDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val bannersFileName = inputData.getString(BANNERS_FILENAME)
            val categoriesFileName = inputData.getString(CATEGORIES_FILENAME)
            val foodItemsFileName = inputData.getString(FOOD_FILENAME)

            val bannersResult = bannersWork(bannersFileName)
            val categoriesResult = categoriesWork(categoriesFileName)
            val foodItemsResult = foodWork(foodItemsFileName)

            if (bannersResult && categoriesResult && foodItemsResult) {
                Log.e(TAG, "Success")
                Result.success()
            } else {
                Log.e(TAG, "Failed")
                Result.failure()
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    private fun bannersWork(name: String?): Boolean {
        if (name != null) {
            applicationContext.assets.open(name).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val bannerType = object : TypeToken<List<BannerEntity>>() {}.type
                    val bannerList: List<BannerEntity> = Gson().fromJson(jsonReader, bannerType)

                    val database = FoodDatabase.getDatabase(applicationContext)
                    bannerList.forEach { database.bannerDao().createBanner(it) }

                    return true
                }
            }
        } else {
            Log.e(TAG, "Error seeding database - no valid filename")
            return false
        }
    }

    private fun categoriesWork(name: String?): Boolean {
        if (name != null) {
            applicationContext.assets.open(name).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val categoryType = object : TypeToken<List<FoodCategoryEntity>>() {}.type
                    val categoryList: List<FoodCategoryEntity> = Gson().fromJson(jsonReader, categoryType)

                    val database = FoodDatabase.getDatabase(applicationContext)
                    categoryList.forEach { database.foodCategoryDao().createFoodCategory(it) }

                    return true
                }
            }
        } else {
            Log.e(TAG, "Error seeding database - no valid filename")
            return false
        }
    }

    private fun foodWork(name: String?): Boolean {
        if (name != null) {
            applicationContext.assets.open(name).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val foodType = object : TypeToken<List<FoodItemEntity>>() {}.type
                    val foodList: List<FoodItemEntity> = Gson().fromJson(jsonReader, foodType)

                    val database = FoodDatabase.getDatabase(applicationContext)
                    foodList.forEach { database.foodItemDao().createFoodItem(it) }

                    return true
                }
            }
        } else {
            Log.e(TAG, "Error seeding database - no valid filename")
            return false
        }
    }

    companion object {
        const val TAG = "FOOD_WORKER_TAG"
        const val BANNERS_FILENAME = "DATA_FILENAME"
        const val CATEGORIES_FILENAME = "DATA_FILENAME"
        const val FOOD_FILENAME = "DATA_FILENAME"
    }
}