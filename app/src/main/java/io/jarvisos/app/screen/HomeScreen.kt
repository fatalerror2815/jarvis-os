package io.jarvisos.app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.jarvisos.app.screen.components.DigitalClock
import io.jarvisos.app.screen.components.Header
import io.jarvisos.app.screen.components.MenuCard
import io.jarvisos.app.screen.components.StatusCard

@Composable
fun HomeScreen() {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Top

    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Header()

        Spacer(modifier = Modifier.height(16.dp))

        DigitalClock()

        Spacer(modifier = Modifier.height(32.dp))

        StatusCard(
            title = "AI CORE",
            status = "ONLINE"
        )

        StatusCard(
            title = "VOICE ENGINE",
            status = "READY"
        )

        StatusCard(
            title = "NETWORK",
            status = "CONNECTED"
        )

        StatusCard(
            title = "BATTERY",
            status = "83%"
        )

        Spacer(modifier = Modifier.height(24.dp))

        MenuCard("🎤 Voice Assistant")

        MenuCard("💬 AI Chat")

        MenuCard("📱 Device Control")

        MenuCard("🏠 Smart Home")

        MenuCard("⚙ Settings")

        Spacer(modifier = Modifier.height(24.dp))

    }

}