package com.mihanovak1024.pogley

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.Forest.plant
import javax.inject.Inject
import javax.inject.Named


@HiltAndroidApp
class PoogleyApplication : Application() {

    @Inject
    @Named("timber_debug_tree")
    lateinit var debugTree: Timber.Tree

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) plant(debugTree)
    }
}