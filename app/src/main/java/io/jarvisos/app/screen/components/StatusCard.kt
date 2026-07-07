package io.jarvisos.app.screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun StatusCard(
    title: String,
    status: String,
    statusColor: Color = Color.Green
) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF111111)
        )

    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Text(
                text = title,
                color = Color.LightGray
            )

            Text(
                text = status,
                color = statusColor,
                fontWeight = FontWeight.Bold
            )

        }

    }

}