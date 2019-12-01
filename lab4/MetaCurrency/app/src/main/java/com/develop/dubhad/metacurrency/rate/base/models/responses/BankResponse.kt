package com.develop.dubhad.metacurrency.rate.base.models.responses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BankResponse(
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val title: String?
)