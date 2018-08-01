package com.litedevs.movieconic.feature.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.litedevs.movieconic.feature.injection.ViewModelFactory
import com.litedevs.movieconic.feature.injection.module.annotation.ViewModelKey
import com.litedevs.presentation.browse.*
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(BrowsePopularMovieViewModel::class)
    abstract fun bindBrowsePopularMoviesViewModel(viewModel : BrowsePopularMovieViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BrowseComingSoonViewModel::class)
    abstract fun bindBrowsComingSoonMoviesViewModel(viewModel : BrowseComingSoonViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BrowseTopMovieViewModel::class)
    abstract fun bindBrowseTopMoviesViewModel(viewModel : BrowseTopMovieViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BrowseRecentMovieViewModel::class)
    abstract fun bindBrowseRecentMoviesViewModel(viewModel : BrowseRecentMovieViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BrowseNowShowingViewModel::class)
    abstract fun bindBrowseNowShowingMoviesViewModel(viewModel : BrowseNowShowingViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BrowseLatestTrailersViewModel::class)
    abstract fun bindBrowseLatestTrailersViewModel(viewModel : BrowseLatestTrailersViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}