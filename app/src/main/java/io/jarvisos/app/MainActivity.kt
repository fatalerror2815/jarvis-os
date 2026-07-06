package io.jarvisos.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import io.jarvisos.app.model.UserProfile
import io.jarvisos.app.screen.HomeScreen
import io.jarvisos.app.screen.SetupScreen
import io.jarvisos.app.screen.SplashScreen
import io.jarvisos.app.storage.UserPreferencesRepository
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // 1. Install Splash Screen bawaan Android 12+
        installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            // Inisialisasi Repository
            val context = LocalContext.current
            val repository = remember { UserPreferencesRepository(context) }
            val userProfile by repository.userProfileFlow.collectAsState(initial = UserProfile())
            val coroutineScope = rememberCoroutineScope()

            // State internal untuk transisi Splash
            var splashFinished by remember { mutableStateOf(false) }

            if (splashFinished) {
                // LOGIKA ROUTING UTAMA
                if (userProfile.firstRun) {
                    SetupScreen(onSetupComplete = {
                        coroutineScope.launch {
                            repository.completeSetup(userName = "Cipto")
                        }
                    })
                } else {
                    HomeScreen()
                }
            } else {
                // Tampilkan komponen Splash kustom kita
                SplashScreen(onFinished = { splashFinished = true })
            }
        }
    }
}