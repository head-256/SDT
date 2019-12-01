package com.develop.dubhad.metacurrency.rate.base.models.responses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RateResponse(
    @Json(name = "date") val date: String?,
    @Json(name = "bank") val bank: BankResponse?,
    @Json(name = "min_rate") val min: Double?,
    @Json(name = "max_rate") val max: Double?,
    @Json(name = "delta_mean") val delta: Double?
)