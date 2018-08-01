package com.litedevs.movieconic.feature.injection.module

import com.litedevs.domain.executor.PostExecutionThread
import com.litedevs.movieconic.feature.UiThread
import com.litedevs.movieconic.feature.browse.*
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {
    @Binds
    abstract fun bindPostExecutionThread(uiThread : UiThread) : PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributesBrowseActivity() : BrowseActivity

    @ContributesAndroidInjector
    abstract fun contributesBrowseTrailersFragment() : BrowseLatestTrailersFragment

    @ContributesAndroidInjector
    abstract fun contributesTopMoviesFragment() : BrowseTopMoviesFragment

    @ContributesAndroidInjector
    abstract fun contributesNowShowingFragment() : BrowseNowShowingFragment

    @ContributesAndroidInjector
    abstract fun contributesComingSoonFragment() : BrowseComingSoonFragment

    @ContributesAndroidInjector
    abstract fun contributesRecentMoviesFragment() : BrowseRecentMoviesFragment

    @ContributesAndroidInjector
    abstract fun contributesPoularMoviesFragment() : BrowsePopularMoviesFragment
}