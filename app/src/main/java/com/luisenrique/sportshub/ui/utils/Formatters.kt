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
        // 1. Define el formato de la fecha de entrada.
        //    DateTimeFormatter.ISO_DATE_TIME es un formateador predefinido para "2024-05-21T18:00:00Z".
        val inputFormatter = DateTimeFormatter.ISO_DATE_TIME

        // 2. Parsea el texto a un objeto LocalDateTime.
        val localDateTime = LocalDateTime.parse(dateUtc, inputFormatter)

        // 3. Define el formato de salida que quieres.
        //    'd MMM yyyy, HH:mm' -> "21 may 2024, 18:00"
        //    'EEEE d 'de' MMMM' -> "martes 21 de mayo"
        //    Usa Locale("es", "ES") para que los nombres de meses y días salgan en español.
        val outputFormatter = DateTimeFormatter.ofPattern("d MMM yyyy, HH:mm", Locale("es", "ES"))

        // 4. Formatea el objeto LocalDateTime al nuevo texto y devuélvelo.
        return localDateTime.format(outputFormatter)

    } catch (e: Exception) {
        // Si hay algún error al parsear la fecha, devuelve el texto original o un mensaje de error.
        e.printStackTrace()
        return "Fecha inválida"
    }
}