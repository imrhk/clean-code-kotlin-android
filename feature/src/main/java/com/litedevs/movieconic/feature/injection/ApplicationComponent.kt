package com.litedevs.movieconic.feature.injection

import android.app.Application
import com.litedevs.movieconic.feature.MovieconicApplication
import com.litedevs.movieconic.feature.injection.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        UiModule::class,
        PresentationModule::class,
        DataModule::class,
        CachedModule::class,
        RemoteModule::class))

interface ApplicationComponent : AndroidInjector<MovieconicApplication>{
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application : Application) : Builder
        fun build() : ApplicationComponent
    }

    override fun inject(app: MovieconicApplication)
}