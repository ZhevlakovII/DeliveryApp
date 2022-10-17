package ru.izhxx.deliveryapp.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.domain.pojo.Banner

interface BannerRepo {
    fun createBanner(banner: Banner)

    fun deleteBanner(banner: Banner)

    fun getLocalBanners(): List<Banner>

    fun getRemoteBanners(): List<Banner>
}