package com.litedevs.presentation.browse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.litedevs.domain.interactor.browse.GetPopularMovies
import com.litedevs.domain.interactor.browse.GetTopMovies
import com.litedevs.presentation.mapper.MovieViewMapper
import com.litedevs.presentation.model.MovieView
import com.litedevs.presentation.resource.Resource
import com.litedevs.presentation.resource.ResourceState
import io.reactivex.observers.DisposableObserver
import model.TMovie
import javax.inject.Inject

class BrowseTopMovieViewModel @Inject constructor(
        getTopMovies: GetTopMovies,
        movieViewMapper: MovieViewMapper) : BrowseMovieViewModel(getTopMovies, movieViewMapper)