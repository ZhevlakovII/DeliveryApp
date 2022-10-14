package ru.izhxx.deliveryapp.presenter.theme

import androidx.compose.runtime.*


@Composable
fun DeliveryAppTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorProvider provides lightTheme,
        content = content
    )
}

object AppTheme {
    val colors: Colors
    @Composable
    @ReadOnlyComposable
    get() = LocalColorProvider.current
}

val LocalColorProvider = staticCompositionLocalOf<Colors> {
    error("No default colors provided")
}