package ru.izhxx.deliveryapp.presenter.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.izhxx.deliveryapp.R

@Composable
fun BannerRow(bannerList: List<String>, onBannerClick: () -> Unit) {
    LazyRow(
        modifier = Modifier.padding(bottom = 24.dp),
        content = {
            bannerList.forEachIndexed { index, banner ->
                when (index) {
                    0 -> item {
                        BannerButton(
                            modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp)
                            .size(300.dp, 120.dp),
                            banner = banner,
                            onBannerClick = onBannerClick
                        )
                    }
                    bannerList.lastIndex -> item {
                        BannerButton(
                            modifier = Modifier
                                .padding(end = 16.dp, top = 16.dp)
                                .size(300.dp, 120.dp),
                            banner = banner,
                            onBannerClick = onBannerClick
                        )
                    }
                    else -> item {
                        BannerButton(
                            modifier = Modifier.padding(top = 16.dp).size(300.dp, 120.dp),
                            banner = banner,
                            onBannerClick = onBannerClick
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun BannerButton(modifier: Modifier, banner: String, onBannerClick: () -> Unit) {
    IconButton(
        modifier = modifier,
        onClick = onBannerClick,
        content = {
            Image(
                painter = painterResource(id = banner.toInt()),
                contentDescription = "Banners",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
        }
    )
}