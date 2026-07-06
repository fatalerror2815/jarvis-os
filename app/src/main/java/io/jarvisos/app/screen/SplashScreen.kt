package io.jarvisos.app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onFinished: () -> Unit
) {

    var progress by remember {
        mutableIntStateOf(0)
    }

    var status by remember {
        mutableStateOf("Initializing AI Core...")
    }

    LaunchedEffect(Unit) {

        while (progress < 100) {

            delay(60)
            progress++

            status = when {

                progress < 20 ->
                    "Initializing AI Core..."

                progress < 40 ->
                    "Loading Memory..."

                progress < 60 ->
                    "Loading Voice Engine..."

                progress < 80 ->
                    "Loading Neural Network..."

                progress < 95 ->
                    "Starting Automation Service..."

                else ->
                    "Finalizing System..."

            }

        }

        delay(700)

        onFinished()

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "JARVIS",
                color = Color.White,
                fontSize = 46.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Artificial Intelligence\nfor Android",
                color = Color.LightGray,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = status,
                color = Color.Cyan
            )

            Spacer(modifier = Modifier.height(18.dp))

            LinearProgressIndicator(
                progress = { progress / 100f },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "$progress%",
                color = Color.White,
                fontSize = 22.sp
            )

        }

    }

}