package io.jarvisos.app.storage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Penyimpanan sementara selama aplikasi berjalan.
 *
 * Nanti pada v0.2 akan diganti menjadi DataStore,
 * sehingga perubahan ke depannya akan mudah.
 */
object UserPreferences {

    // Apakah aplikasi baru pertama kali dijalankan?
    var firstRun by mutableStateOf(true)

    // Nama pengguna
    var userName by mutableStateOf("Guest")

    /**
     * Dipanggil setelah Setup Screen selesai.
     */
    fun completeSetup(name: String) {
        userName = name.trim().ifEmpty { "Guest" }
        firstRun = false
    }

    /**
     * Untuk testing.
     */
    fun reset() {
        userName = "Guest"
        firstRun = true
    }
}