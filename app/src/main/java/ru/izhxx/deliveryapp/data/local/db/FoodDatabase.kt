package ru.izhxx.deliveryapp.data.local.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import ru.izhxx.deliveryapp.BuildConfig
import ru.izhxx.deliveryapp.data.local.entities.BannerEntity
import ru.izhxx.deliveryapp.data.local.entities.FoodCategoryEntity
import ru.izhxx.deliveryapp.data.local.entities.FoodItemEntity
import ru.izhxx.deliveryapp.utils.BANNER_DATA
import ru.izhxx.deliveryapp.utils.CATEGORIES_DATA
import ru.izhxx.deliveryapp.utils.FOOD_DATA
import ru.izhxx.deliveryapp.utils.FoodDatabaseWorker
import ru.izhxx.deliveryapp.utils.FoodDatabaseWorker.Companion.BANNERS_FILENAME
import ru.izhxx.deliveryapp.utils.FoodDatabaseWorker.Companion.CATEGORIES_FILENAME
import ru.izhxx.deliveryapp.utils.FoodDatabaseWorker.Companion.FOOD_FILENAME

@Database(
    entities = [BannerEntity::class, FoodItemEntity::class, FoodCategoryEntity::class],
    version = 1
)
abstract class FoodDatabase : RoomDatabase() {
    abstract fun bannerDao(): BannerDao
    abstract fun foodCategoryDao(): FoodCategoryDao
    abstract fun foodItemDao(): FoodItemDao

    companion object {
        @Volatile
        private var databaseInstance: FoodDatabase? = null

        fun getDatabase(context: Context): FoodDatabase {
            return databaseInstance ?: synchronized(this) {
                databaseInstance ?: buildDatabase(context).also { databaseInstance = it }
            }
        }

        private fun buildDatabase(context: Context): FoodDatabase {
            return Room.databaseBuilder(
                context,
                FoodDatabase::class.java,
                BuildConfig.DATABASE_NAME
            ).addCallback(
                object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        Log.e("DATA", "CREATE")
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<FoodDatabaseWorker>()
                            .setInputData(
                                workDataOf(
                                    BANNERS_FILENAME to BANNER_DATA,
                                    CATEGORIES_FILENAME to CATEGORIES_DATA,
                                    FOOD_FILENAME to FOOD_DATA
                                )
                            )
                            .build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                }
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}