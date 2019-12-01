package com.develop.dubhad.metacurrency.base.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.develop.dubhad.metacurrency.base.viewmodels.ViewModelFactory
import com.develop.dubhad.metacurrency.base.viewmodels.ViewModelKey
import com.develop.dubhad.metacurrency.rate.list.viewmodels.RateListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RateListViewModel::class)
    abstract fun bindRateListViewModel(rateListViewModel: RateListViewModel): ViewModel
}