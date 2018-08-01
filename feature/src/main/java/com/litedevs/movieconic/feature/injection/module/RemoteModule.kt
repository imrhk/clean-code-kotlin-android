package com.litedevs.movieconic.feature.injection.module

import com.litedevs.data.repository.MovieRemote
import com.litedevs.movieconic.BuildConfig
import com.litedevs.remote.MoviesRemoteImpl
import com.litedevs.remote.service.TmdbApiService
import com.litedevs.remote.service.TmdbApiServiceFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RemoteModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providesGithubService() : TmdbApiService {
            return TmdbApiServiceFactory.makeTmdbApiService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindMovieRemote(movieRemote : MoviesRemoteImpl) : MovieRemote
}