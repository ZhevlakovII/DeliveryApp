package ru.izhxx.deliveryapp.presenter.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.izhxx.deliveryapp.data.repo.BannerRepoImpl
import ru.izhxx.deliveryapp.data.repo.FoodCategoryRepoImpl
import ru.izhxx.deliveryapp.data.repo.FoodItemRepoImpl
import ru.izhxx.deliveryapp.domain.repository.BannerRepo
import ru.izhxx.deliveryapp.domain.repository.FoodCategoryRepo
import ru.izhxx.deliveryapp.domain.repository.FoodItemRepo
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Singleton
    @Provides
    fun provideBannerRepo(bannerRepoImpl: BannerRepoImpl): BannerRepo {
        return bannerRepoImpl
    }

    @Singleton
    @Provides
    fun provideFoodCategoryRepo(foodCategoryRepoImpl: FoodCategoryRepoImpl): FoodCategoryRepo {
        return foodCategoryRepoImpl
    }

    @Singleton
    @Provides
    fun provideFoodItemRepo(foodItemRepoImpl: FoodItemRepoImpl): FoodItemRepo {
        return foodItemRepoImpl
    }
}