package com.develop.dubhad.metacurrency.rate.base.models.domain

import android.os.Parcelable
import com.develop.dubhad.metacurrency.rate.base.models.responses.BankResponse
import com.develop.dubhad.sunflower.base.exceptions.ParsingServerException
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Bank(val id: Int, val title: String) : Parcelable {
    constructor(response: BankResponse) : this(
        id = response.id ?: throw ParsingServerException(),
        title = response.title ?: throw ParsingServerException()
    )
}