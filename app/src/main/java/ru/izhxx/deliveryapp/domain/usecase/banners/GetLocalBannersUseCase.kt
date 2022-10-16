package ru.izhxx.deliveryapp.domain.usecase.banners

import kotlinx.coroutines.flow.Flow
import ru.izhxx.deliveryapp.domain.pojo.Banner
import ru.izhxx.deliveryapp.domain.repository.BannerRepo
import javax.inject.Inject

class GetLocalBannersUseCase @Inject constructor(private val bannerRepo: BannerRepo) {
    fun invoke(): Flow<List<Banner>> {
        return bannerRepo.getLocalBanners()
    }
}