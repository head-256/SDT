package com.develop.dubhad.metacurrency.rate.base.models.responses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrencyResponse(
    @Json(name = "id") val id: String?,
    @Json(name = "name") val title: String?
)