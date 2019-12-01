package com.develop.dubhad.metacurrency.rate.base.services

import com.develop.dubhad.metacurrency.rate.base.models.responses.BankResponse
import com.develop.dubhad.metacurrency.rate.base.models.responses.CurrencyResponse
import com.develop.dubhad.metacurrency.rate.base.models.responses.RateResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {

    @GET("currencies/")
    fun getCurrencies(): Single<List<CurrencyResponse>>

    @GET("banks/")
    fun getBanks(): Single<List<BankResponse>>

    @GET("rates/")
    fun getRates(
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("sort") sort: String = "-mean_rate",
        @Query("banks") banks: Int? = null,
        @Query("count") count: Int = 1
    ): Single<List<RateResponse>>
}