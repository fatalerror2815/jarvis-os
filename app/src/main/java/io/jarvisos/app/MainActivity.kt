package io.jarvisos.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import io.jarvisos.app.screen.HomeScreen
import io.jarvisos.app.screen.SetupScreen
import io.jarvisos.app.screen.SplashScreen
import io.jarvisos.app.storage.UserPreferences

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            var splashFinished by remember {
                mutableStateOf(false)
            }

            var setupFinished by remember {
                mutableStateOf(!UserPreferences.firstRun)
            }

            when {

                // Splash Screen
                !splashFinished -> {

                    SplashScreen(
                        onFinished = {
                            splashFinished = true
                        }
                    )

                }

                // First Setup
                !setupFinished -> {

                    SetupScreen(

                        onSetupComplete = { userName ->

                            UserPreferences.completeSetup(userName)

                            setupFinished = true

                        }

                    )

                }

                // Home Screen
                else -> {

                    HomeScreen()

                }

            }

        }
    }
}