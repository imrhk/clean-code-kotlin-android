package com.litedevs.presentation.browse

import com.litedevs.domain.interactor.browse.GetRecentMovies
import com.litedevs.presentation.mapper.MovieViewMapper
import javax.inject.Inject

class BrowseRecentMovieViewModel @Inject constructor(
        getRecentMovies: GetRecentMovies,
        movieViewMapper: MovieViewMapper) : BrowseMovieViewModel(getRecentMovies, movieViewMapper)