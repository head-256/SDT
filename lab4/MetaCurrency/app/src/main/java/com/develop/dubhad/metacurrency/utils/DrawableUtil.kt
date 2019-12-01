package com.develop.dubhad.metacurrency.utils

import androidx.annotation.DrawableRes
import com.develop.dubhad.metacurrency.R
import com.develop.dubhad.metacurrency.rate.base.models.domain.Tendency

object DrawableUtil {

    @DrawableRes
    fun getArrow(tendency: Tendency): Int {
        return when (tendency) {
            Tendency.UP -> R.drawable.ic_arrow_up
            Tendency.DOWN -> R.drawable.ic_arrow_down
            Tendency.NEUTRAL -> R.drawable.ic_equal
        }
    }
}