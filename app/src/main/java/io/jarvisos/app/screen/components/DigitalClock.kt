package io.jarvisos.app.screen.components

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun DigitalClock() {

    var time by remember {

        mutableStateOf(
            LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm"))
        )

    }

    LaunchedEffect(Unit) {

        while (true) {

            time = LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm"))

            delay(1000)

        }

    }

    Text(

        text = time,

        color = Color.Cyan,

        fontSize = 28.sp,

        fontWeight = FontWeight.Bold

    )

}