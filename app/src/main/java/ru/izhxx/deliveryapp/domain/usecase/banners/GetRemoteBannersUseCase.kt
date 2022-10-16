package ru.izhxx.deliveryapp.domain.usecase.banners

import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.domain.pojo.Banner
import ru.izhxx.deliveryapp.domain.repository.BannerRepo
import javax.inject.Inject

class GetRemoteBannersUseCase @Inject constructor(private val bannerRepo: BannerRepo) {
    fun invoke(): List<Banner> {
        return bannerRepo.getRemoteBanners()
    }
}