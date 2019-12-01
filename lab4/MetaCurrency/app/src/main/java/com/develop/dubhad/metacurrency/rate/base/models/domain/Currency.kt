package com.develop.dubhad.metacurrency.rate.base.models.domain

import android.os.Parcelable
import com.develop.dubhad.metacurrency.rate.base.models.responses.CurrencyResponse
import com.develop.dubhad.sunflower.base.exceptions.ParsingServerException
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Currency(val id: String, val title: String) : Parcelable {
    constructor(response: CurrencyResponse) : this(
        id = response.id ?: throw ParsingServerException(),
        title = response.title ?: throw ParsingServerException()
    )
}