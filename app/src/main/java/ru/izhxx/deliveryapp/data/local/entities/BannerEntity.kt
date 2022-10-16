package ru.izhxx.deliveryapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "banners")
data class BannerEntity(
    @PrimaryKey
    val bannerId: Int,

    val bannerUrl: String
)