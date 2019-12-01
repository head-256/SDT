package com.develop.dubhad.metacurrency.rate.base.models.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rate(
    val minRate: Double,
    val maxRate: Double,
    val tendency: Tendency,
    val isBest: Boolean
) : Parcelable