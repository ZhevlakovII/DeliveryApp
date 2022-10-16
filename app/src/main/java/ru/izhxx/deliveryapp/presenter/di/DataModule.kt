package ru.izhxx.deliveryapp.presenter.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.izhxx.deliveryapp.data.local.db.BannerDao
import ru.izhxx.deliveryapp.data.local.db.FoodCategoryDao
import ru.izhxx.deliveryapp.data.local.db.FoodDatabase
import ru.izhxx.deliveryapp.data.local.db.FoodItemDao
import ru.izhxx.deliveryapp.data.local.entities.FoodCategoryEntity
import ru.izhxx.deliveryapp.data.mapper.BannerEntityMapper
import ru.izhxx.deliveryapp.data.mapper.FoodCategoryEntityMapper
import ru.izhxx.deliveryapp.data.mapper.FoodItemMapper
import ru.izhxx.deliveryapp.data.repo.BannerRepoImpl
import ru.izhxx.deliveryapp.data.repo.FoodCategoryRepoImpl
import ru.izhxx.deliveryapp.data.repo.FoodItemRepoImpl
import ru.izhxx.deliveryapp.data.repo.banners.BannerDataSource
import ru.izhxx.deliveryapp.data.repo.banners.BannerDataSourceImpl
import ru.izhxx.deliveryapp.data.repo.categories.FoodCategoryDataSource
import ru.izhxx.deliveryapp.data.repo.categories.FoodCategoryDataSourceImpl
import ru.izhxx.deliveryapp.data.repo.fooditems.FoodItemDataSource
import ru.izhxx.deliveryapp.data.repo.fooditems.FoodItemDataSourceImpl
import ru.izhxx.deliveryapp.domain.repository.BannerRepo
import ru.izhxx.deliveryapp.domain.repository.FoodCategoryRepo
import ru.izhxx.deliveryapp.domain.repository.FoodItemRepo
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Singleton
    @Provides
    fun provideFoodDatabase(@ApplicationContext context: Context): FoodDatabase {
        return FoodDatabase.getDatabase(context)
    }

    @Singleton
    @Provides
    fun provideBannerDataSource(bannerDataSourceImpl: BannerDataSourceImpl): BannerDataSource {
        return bannerDataSourceImpl
    }

    @Singleton
    @Provides
    fun provideFoodCategoryDataSource(
        foodCategoryDataSourceImpl: FoodCategoryDataSourceImpl
    ): FoodCategoryDataSource {
        return foodCategoryDataSourceImpl
    }

    @Singleton
    @Provides
    fun provideFoodItemDataSource(foodItemDataSourceImpl: FoodItemDataSourceImpl): FoodItemDataSource {
        return foodItemDataSourceImpl
    }

    @Singleton
    @Provides
    fun provideBannerDao(foodDatabase: FoodDatabase): BannerDao {
        return foodDatabase.bannerDao()
    }

    @Singleton
    @Provides
    fun provideFoodCategoryDao(foodDatabase: FoodDatabase): FoodCategoryDao {
        return foodDatabase.foodCategoryDao()
    }

    @Singleton
    @Provides
    fun provideFoodItemDao(foodDatabase: FoodDatabase): FoodItemDao {
        return foodDatabase.foodItemDao()
    }

    @Singleton
    @Provides
    fun provideBannerMapper(): BannerEntityMapper {
        return BannerEntityMapper()
    }

    @Singleton
    @Provides
    fun provideFoodCategoryMapper(): FoodCategoryEntityMapper {
        return FoodCategoryEntityMapper()
    }

    @Singleton
    @Provides
    fun provideFoodItemMapper(): FoodItemMapper {
        return FoodItemMapper()
    }
}