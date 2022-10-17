package ru.izhxx.deliveryapp.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.data.local.entities.BannerEntity
import ru.izhxx.deliveryapp.domain.pojo.Banner

@Dao
interface BannerDao {
    @Query("SELECT * FROM banners")
    fun getBanners(): List<BannerEntity>

    @Insert
    fun createBanner(banner: BannerEntity)

    @Delete
    fun deleteBanner(banner: BannerEntity)
}