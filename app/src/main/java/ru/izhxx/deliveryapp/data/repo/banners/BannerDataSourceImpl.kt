package ru.izhxx.deliveryapp.data.repo.banners

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.izhxx.deliveryapp.data.local.db.BannerDao
import ru.izhxx.deliveryapp.data.mapper.BannerEntityMapper
import ru.izhxx.deliveryapp.domain.pojo.Banner
import javax.inject.Inject

class BannerDataSourceImpl @Inject constructor(
    private val bannerDao: BannerDao,
    private val bannerEntityMapper: BannerEntityMapper
) : BannerDataSource {
    override fun createBanner(banner: Banner) {
        bannerDao.createBanner(banner = bannerEntityMapper.toEntity(banner))
    }

    override fun deleteBanner(banner: Banner) {
        bannerDao.deleteBanner(banner = bannerEntityMapper.toEntity(banner))
    }

    override fun getBanners(): Flow<List<Banner>> {
        val bannerFlow = bannerDao.getBanners()
        return bannerFlow.map { list ->
            list.map { element ->
                bannerEntityMapper.toItem(element)
            }
        }
    }
}