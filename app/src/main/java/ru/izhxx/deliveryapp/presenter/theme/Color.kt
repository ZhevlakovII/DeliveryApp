package ru.izhxx.deliveryapp.presenter.theme

import androidx.compose.ui.graphics.Color


data class Colors(
    val actionColor: Color,
    val navigationBackgroundColor: Color,
    val inactiveColor: Color,
    val textHeaderColor: Color,
    val textBodyColor: Color,
    val hintColor: Color,
)

val lightTheme = Colors(
    actionColor = Color(0xFFFD3A69),
    navigationBackgroundColor = Color(0xFFF0F0F0),
    inactiveColor = Color(0xFF7B7B7B),
    textHeaderColor = Color(0xFF222831),
    textBodyColor = Color(0xFFAAAAAD),
    hintColor = Color(0xFFC3C4C9)
)