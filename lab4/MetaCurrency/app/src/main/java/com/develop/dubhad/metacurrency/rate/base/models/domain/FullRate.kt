package com.develop.dubhad.metacurrency.rate.base.models.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FullRate(
    val currency: Currency,
    val bank: Bank,
    val sellingRate: Rate,
    val buyingRate: Rate
) : Parcelable