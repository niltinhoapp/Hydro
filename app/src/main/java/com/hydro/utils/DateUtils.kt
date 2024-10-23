package com.hydro.utils

import java.text.SimpleDateFormat
import java.util.*

// Utilitário para manipulação de datas
object DateUtils {

    // Formato de data padrão
    private const val DEFAULT_DATE_FORMAT = "dd/MM/yyyy"

    // Conversão de data para string
    fun formatDate(date: Date?): String {
        return SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date)
    }

    // Conversão de string para data
    fun parseDate(dateString: String?): Date? {
        return SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(dateString)
    }

    // Obter data atual
    fun getCurrentDate(): Date {
        return Calendar.getInstance().time
    }

    // Adicionar dias à data
    fun addDays(date: Date, days: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DAY_OF_MONTH, days)
        return calendar.time
    }

    // Subtrair dias da data
    fun subtractDays(date: Date, days: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DAY_OF_MONTH, -days)
        return calendar.time
    }
}

