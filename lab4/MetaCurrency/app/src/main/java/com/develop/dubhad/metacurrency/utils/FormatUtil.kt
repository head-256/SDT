package com.develop.dubhad.metacurrency.utils

import java.text.DecimalFormat

object FormatUtil {

    fun getFormattedRate(minRate: Double, maxRate: Double): String {
        val df = DecimalFormat("#.###")
        val result = df.format((minRate + maxRate) / 2)
        val diff = maxRate - minRate
        val diffString = df.format(diff)
        if (diff > 0) {
            return "${result}±${diffString}"
        } else {
            return result
        }
    }
}