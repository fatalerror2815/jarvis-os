package io.jarvisos.app.screen // Sesuaikan dengan folder screen Anda

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SetupScreen(
    onSetupComplete: () -> Unit // Tambahkan parameter callback ini
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black), // Sesuai tema aplikasi
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "FIRST SETUP",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { onSetupComplete() }) {
                Text("Complete Setup")
            }
        }
    }
}