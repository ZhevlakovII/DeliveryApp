package ru.izhxx.deliveryapp.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import ru.izhxx.deliveryapp.presenter.screens.main.MainScreen
import ru.izhxx.deliveryapp.presenter.theme.DeliveryAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeliveryAppTheme {
                MainScreen()
            }
        }
    }

}