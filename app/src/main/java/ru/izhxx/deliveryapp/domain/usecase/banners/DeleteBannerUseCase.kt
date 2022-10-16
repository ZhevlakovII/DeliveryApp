package ru.izhxx.deliveryapp.domain.usecase.banners

import ru.izhxx.deliveryapp.domain.pojo.Banner
import ru.izhxx.deliveryapp.domain.repository.BannerRepo
import javax.inject.Inject

class DeleteBannerUseCase @Inject constructor(private val bannerRepo: BannerRepo) {
    fun invoke(banner: Banner) {
        bannerRepo.deleteBanner(banner = banner)
    }
}