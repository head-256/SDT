package com.develop.dubhad.metacurrency.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

object GraphUtil {

    fun getWeeklyGraph(currencyIdFrom: String, currencyIdTo: String, bankId: Int): String {
        val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.US)
        val currentDate = sdf.format(Date())
        val calendar = Calendar.getInstance()
        calendar.time = Date()
        calendar.add(Calendar.DAY_OF_MONTH, -7)
        val fromDate = sdf.format(calendar.time)
        return getGraphUrl(currencyIdFrom, currencyIdTo, bankId, fromDate, currentDate)
    }

    fun getGraphUrl(
        currencyIdFrom: String,
        currencyIdTo: String,
        bankId: Int,
        from: String,
        to: String
    ): String {
        return "${BASE_URL}graph/?from=${currencyIdFrom}&to=${currencyIdTo}&banks=${bankId}&date_from=${from}&date_to=${to}"
    }
}