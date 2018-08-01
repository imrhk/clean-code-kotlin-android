package com.litedevs.movieconic.feature.injection.module

import android.app.Application
import com.litedevs.cache.CachedMoviesImpl
import com.litedevs.cache.db.MovieDatabase
import com.litedevs.data.repository.MoviesCache
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class CachedModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providesDatabase(application: Application) : MovieDatabase {
            return MovieDatabase.getInstance(application.applicationContext)
        }
    }
    @Binds
    abstract fun bindMoviesCache(projectsCache: CachedMoviesImpl) : MoviesCache
}