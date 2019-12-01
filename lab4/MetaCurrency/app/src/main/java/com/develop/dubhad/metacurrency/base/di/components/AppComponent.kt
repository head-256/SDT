package com.develop.dubhad.metacurrency.base.di.components

import android.app.Application
import com.develop.dubhad.metacurrency.App
import com.develop.dubhad.metacurrency.base.di.modules.ActivityModule
import com.develop.dubhad.metacurrency.base.di.modules.AppModule
import com.develop.dubhad.metacurrency.base.di.modules.NetworkModule
import com.develop.dubhad.metacurrency.base.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        AppModule::class,
        ActivityModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    fun inject(app: App)
}