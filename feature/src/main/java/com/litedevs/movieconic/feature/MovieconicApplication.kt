package com.litedevs.movieconic.feature
import dagger.android.AndroidInjector

import com.litedevs.movieconic.feature.injection.DaggerApplicationComponent
import dagger.android.DaggerApplication


import timber.log.Timber

class MovieconicApplication : DaggerApplication() {

    private val appComponent: AndroidInjector<MovieconicApplication> by lazy {
        val appComponent = DaggerApplicationComponent
                .builder()
                .application(this)
                .build()

        appComponent.inject(this)
        appComponent
    }

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() = Timber.plant(Timber.DebugTree())

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = appComponent

}