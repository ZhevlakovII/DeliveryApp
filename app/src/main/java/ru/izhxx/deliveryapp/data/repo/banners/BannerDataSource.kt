package ru.izhxx.deliveryapp.data.repo.banners

import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.domain.pojo.Banner

interface BannerDataSource {
    fun createBanner(banner: Banner)

    fun deleteBanner(banner: Banner)

    fun getBanners(): List<Banner>
}