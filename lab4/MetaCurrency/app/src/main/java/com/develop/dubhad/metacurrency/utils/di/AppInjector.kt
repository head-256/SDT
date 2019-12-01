package com.develop.dubhad.metacurrency.utils.di

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.develop.dubhad.metacurrency.App
import com.develop.dubhad.metacurrency.base.di.components.DaggerAppComponent
import com.develop.dubhad.metacurrency.utils.ActivityLifecycleCallbacksHelper
import dagger.android.AndroidInjection
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection

object AppInjector {
    fun init(app: App) {
        DaggerAppComponent.factory()
            .create(app)
            .inject(app)

        app.registerActivityLifecycleCallbacks(ActivityLifecycleCallbacksHelper(onCreated = {
            handleActivity(it)
        }))
    }

    private fun handleActivity(activity: Activity) {
        if (activity is HasAndroidInjector) {
            AndroidInjection.inject(activity)
        }
        if (activity is FragmentActivity) {
            activity.supportFragmentManager
                .registerFragmentLifecycleCallbacks(
                    object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(
                            fm: FragmentManager,
                            f: Fragment,
                            savedInstanceState: Bundle?
                        ) {
                            if (f is Injectable) {
                                AndroidSupportInjection.inject(f)
                            }
                        }
                    }, true
                )
        }
    }
}