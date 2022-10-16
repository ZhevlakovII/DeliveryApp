package ru.izhxx.deliveryapp.data.mapper

import ru.izhxx.deliveryapp.data.local.entities.BannerEntity
import ru.izhxx.deliveryapp.domain.pojo.Banner

class BannerEntityMapper {
    fun toEntity(banner: Banner): BannerEntity {
        return BannerEntity(
            bannerId = banner.bannerId,
            bannerUrl = banner.bannerUrl
        )
    }

    fun toItem(bannerEntity: BannerEntity): Banner {
        return Banner(
            bannerId = bannerEntity.bannerId,
            bannerUrl = bannerEntity.bannerUrl
        )
    }
}