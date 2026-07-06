package io.jarvisos.app.storage

import androidx.compose.runtime.mutableStateOf

object UserPreferences {

    val userName = mutableStateOf("Guest")

    val firstRun = mutableStateOf(true)

}