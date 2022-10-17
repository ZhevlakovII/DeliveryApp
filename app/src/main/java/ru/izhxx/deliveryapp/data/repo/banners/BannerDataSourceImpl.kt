package ru.izhxx.deliveryapp.data.repo.banners

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

    /*
    * The method returns a fake date due to the lack of a correct api for the application
    * This changes only on develop branch
    */
    override fun getBanners(): List<Banner> {
        return mutableListOf(
            Banner(1, "SomeUrl"),
            Banner(2, "SomeUrl"),
            Banner(3, "SomeUrl")
        )
//        val bannerFlow = bannerDao.getBanners()
//        return bannerFlow.map { item ->
//            bannerEntityMapper.toItem(item)
//        }
    }
}