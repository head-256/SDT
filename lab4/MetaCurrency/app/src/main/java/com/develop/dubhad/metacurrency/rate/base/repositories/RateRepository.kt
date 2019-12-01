package com.develop.dubhad.metacurrency.rate.base.repositories

import com.develop.dubhad.metacurrency.rate.base.models.domain.Currency
import com.develop.dubhad.metacurrency.rate.base.models.responses.RateResponse
import com.develop.dubhad.metacurrency.rate.base.services.MainApi
import com.develop.dubhad.sunflower.base.exceptions.ParsingServerException
import io.reactivex.Single
import javax.inject.Inject

class RateRepository @Inject constructor(private val mainApi: MainApi) {

    fun fetchLastRates(currencyFromId: String, currencyToId: String): Single<List<RateResponse>> {
        return mainApi.getRates(currencyFromId, currencyToId)
    }

    fun fetchRate(currencyFromId: String, currencyToId: String, bankId: Int): Single<RateResponse> {
        return mainApi.getRates(currencyFromId, currencyToId, banks = bankId).map { it.first() }
    }

    fun fetchCurrency(currencyId: String): Single<Currency> {
        return mainApi.getCurrencies()
            .map { Currency(it.find { it.id == currencyId } ?: throw ParsingServerException()) }
    }
}