package com.litedevs.movieconic.feature.injection.module

import com.litedevs.data.MovieDataRepository
import com.litedevs.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {
    @Binds
    abstract fun bindDataRepository(dataRepository: MovieDataRepository) : MovieRepository
}