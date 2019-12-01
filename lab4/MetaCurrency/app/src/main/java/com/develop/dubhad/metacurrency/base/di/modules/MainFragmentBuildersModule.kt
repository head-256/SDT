package com.develop.dubhad.metacurrency.base.di.modules

import com.develop.dubhad.metacurrency.rate.info.ui.RateInfoFragment
import com.develop.dubhad.metacurrency.rate.list.ui.RateListFragment
import com.develop.dubhad.metacurrency.settings.SettingsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeRateInfoFragment(): RateInfoFragment

    @ContributesAndroidInjector
    abstract fun contributeRateListFragment(): RateListFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingsFragment(): SettingsFragment
}