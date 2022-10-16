package ru.izhxx.deliveryapp.data.repo

import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.data.repo.banners.BannerDataSource
import ru.izhxx.deliveryapp.domain.pojo.Banner
import ru.izhxx.deliveryapp.domain.repository.BannerRepo
import javax.inject.Inject

class BannerRepoImpl @Inject constructor(private val bannerDataSource: BannerDataSource) : BannerRepo {
    override fun createBanner(banner: Banner) {
        bannerDataSource.createBanner(banner = banner)
    }

    override fun deleteBanner(banner: Banner) {
        bannerDataSource.deleteBanner(banner = banner)
    }

    override fun getLocalBanners(): Flow<List<Banner>> {
        return bannerDataSource.getBanners()
    }

    override fun getRemoteBanners(): List<Banner> {
        TODO("Not yet implemented")
    }
}