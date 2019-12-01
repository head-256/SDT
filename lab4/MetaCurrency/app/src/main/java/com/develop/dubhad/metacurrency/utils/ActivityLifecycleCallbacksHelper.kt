package com.develop.dubhad.metacurrency.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle

class ActivityLifecycleCallbacksHelper(private val onCreated: (activity: Activity) -> Unit = {}) :
    Application.ActivityLifecycleCallbacks {

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        activity?.let { onCreated(it) }
    }

    override fun onActivityPaused(activity: Activity?) {
        // NOOP
    }

    override fun onActivityResumed(activity: Activity?) {
        // NOOP
    }

    override fun onActivityStarted(activity: Activity?) {
        // NOOP
    }

    override fun onActivityDestroyed(activity: Activity?) {
        // NOOP
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        // NOOP
    }

    override fun onActivityStopped(activity: Activity?) {
        // NOOP
    }
}
