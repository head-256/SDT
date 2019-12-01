package com.develop.dubhad.metacurrency.rate.list.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.develop.dubhad.metacurrency.base.models.Resource
import com.develop.dubhad.metacurrency.base.viewmodels.BaseViewModel
import com.develop.dubhad.metacurrency.rate.base.models.domain.Bank
import com.develop.dubhad.metacurrency.rate.base.models.domain.FullRate
import com.develop.dubhad.metacurrency.rate.base.models.domain.Rate
import com.develop.dubhad.metacurrency.rate.base.models.domain.Tendency
import com.develop.dubhad.metacurrency.rate.base.repositories.RateRepository
import com.develop.dubhad.metacurrency.utils.extensions.subscribeWithResource
import com.develop.dubhad.sunflower.base.exceptions.ParsingServerException
import io.reactivex.rxkotlin.Singles
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class RateListViewModel @Inject constructor(private val repository: RateRepository) :
    BaseViewModel() {

    private val _resource: MutableLiveData<Resource<List<FullRate>>> = MutableLiveData()

    val resource: LiveData<Resource<List<FullRate>>>
        get() = _resource

    fun fetchLastRates(currencyId: String) {
        val ratesMap = mutableMapOf<Bank, MutableList<Rate>>()
        Singles.zip(
            repository.fetchLastRates("BYN", currencyId),
            repository.fetchLastRates(currencyId, "BYN"),
            repository.fetchCurrency(currencyId)
        ) { sellingRates, buyingRates, currency ->
            sellingRates.forEachIndexed { i, rate ->
                ratesMap[Bank(rate.bank ?: throw ParsingServerException())] = mutableListOf()
                ratesMap[Bank(rate.bank)]?.add(
                    Rate(
                        rate.min ?: throw ParsingServerException(),
                        rate.max ?: throw ParsingServerException(),
                        getTendency(rate.delta ?: throw ParsingServerException()),
                        i == 0
                    )
                )
            }
            buyingRates.forEachIndexed { i, rate ->
                ratesMap[Bank(rate.bank ?: throw ParsingServerException())]?.add(
                    Rate(
                        rate.min ?: throw ParsingServerException(),
                        rate.max ?: throw ParsingServerException(),
                        getTendency(rate.delta ?: throw ParsingServerException()),
                        i == 0
                    )
                )
            }
            ratesMap.map { FullRate(currency, it.key, it.value[0], it.value[1]) }
        }
            .subscribeWithResource(_resource)
            .addTo(disposables)
    }

    private fun getTendency(delta: Double): Tendency {
        return when {
            delta > 0 -> Tendency.UP
            delta < 0 -> Tendency.DOWN
            else -> Tendency.NEUTRAL
        }
    }
}