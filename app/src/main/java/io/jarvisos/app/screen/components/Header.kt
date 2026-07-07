package io.jarvisos.app.screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import io.jarvisos.app.storage.UserPreferences
import java.time.LocalTime

@Composable
fun Header() {

    val hour = LocalTime.now().hour

    val greeting = when (hour) {
        in 5..10 -> "Good Morning"
        in 11..14 -> "Good Afternoon"
        in 15..18 -> "Good Evening"
        else -> "Good Night"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "JARVIS",
            color = Color.White,
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "$greeting, ${UserPreferences.userName}",
            color = Color.LightGray,
            fontSize = 18.sp
        )
    }
}