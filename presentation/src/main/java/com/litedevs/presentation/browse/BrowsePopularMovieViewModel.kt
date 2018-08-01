package com.litedevs.presentation.browse

import com.litedevs.domain.interactor.browse.GetPopularMovies
import com.litedevs.presentation.mapper.MovieViewMapper
import javax.inject.Inject

class BrowsePopularMovieViewModel @Inject constructor(
        getPopularMovies: GetPopularMovies,
        movieViewMapper: MovieViewMapper) : BrowseMovieViewModel(getPopularMovies, movieViewMapper)