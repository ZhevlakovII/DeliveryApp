package ru.izhxx.deliveryapp.presenter.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.izhxx.deliveryapp.R
import ru.izhxx.deliveryapp.presenter.theme.DeliveryTypography
import ru.izhxx.deliveryapp.presenter.theme.lightTheme

@Composable
fun TopBar(city: String) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row {
            Text(
                text = city,
                style = DeliveryTypography.headlineMedium,
                color = lightTheme.textHeaderColor,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            IconButton(
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.drop_down_icon),
                        contentDescription = "Drop down icon"
                    )
                },
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Spacer(modifier = Modifier.weight(1f, true))

        IconButton(
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.qr_code_icon),
                    contentDescription = "QR-code button"
                )
            },
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterVertically)
        )

    }
}