package io.jarvisos.app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.jarvisos.app.storage.UserPreferences

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "JARVIS",
            color = Color.White,
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Good Afternoon, ${UserPreferences.userName}",
            color = Color.LightGray,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

        MenuCard("🎤 Voice Assistant")
        MenuCard("💬 AI Chat")
        MenuCard("📱 Device Control")
        MenuCard("🏠 Smart Home")
        MenuCard("⚙ Settings")

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "SYSTEM STATUS",
            color = Color.Cyan,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(15.dp))

        StatusItem("AI Core", "ONLINE")
        StatusItem("Memory", "READY")
        StatusItem("Voice Engine", "ACTIVE")
        StatusItem("Battery", "83%")
    }
}

@Composable
fun MenuCard(title: String) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1A1A1A)
        ),

        shape = RoundedCornerShape(16.dp)
    ) {

        Text(
            text = title,
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(18.dp)
        )

    }
}

@Composable
fun StatusItem(name: String, value: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),

        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = name,
            color = Color.LightGray
        )

        Text(
            text = value,
            color = Color.Green
        )

    }
}