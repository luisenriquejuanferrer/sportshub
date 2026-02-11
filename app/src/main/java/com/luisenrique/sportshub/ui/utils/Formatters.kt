package com.luisenrique.sportshub.ui.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
fun formatUtcDate(dateUtc: String?): String {
    if (dateUtc.isNullOrBlank()) {
        return "Fecha no disponible"
    }

    try {
        val inputFormatter = DateTimeFormatter.ISO_DATE_TIME

        val localDateTime = LocalDateTime.parse(dateUtc, inputFormatter)

        val outputFormatter = DateTimeFormatter.ofPattern("d MMM yyyy, HH:mm", Locale("es", "ES"))

        return localDateTime.format(outputFormatter)
    } catch (e: Exception) {
        e.printStackTrace()
        return "Fecha inválida"
    }
}