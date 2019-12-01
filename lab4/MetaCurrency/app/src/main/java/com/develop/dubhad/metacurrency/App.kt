package com.develop.dubhad.metacurrency

import android.app.Application
import com.develop.dubhad.metacurrency.utils.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.reactivex.plugins.RxJavaPlugins
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        AppInjector.init(this)

        RxJavaPlugins.setErrorHandler { }
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
