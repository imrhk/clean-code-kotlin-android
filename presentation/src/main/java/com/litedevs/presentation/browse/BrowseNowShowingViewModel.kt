package com.litedevs.presentation.browse

import com.litedevs.domain.interactor.browse.GetNowShowingMovies
import com.litedevs.domain.interactor.browse.GetRecentMovies
import com.litedevs.presentation.mapper.MovieViewMapper
import javax.inject.Inject

class BrowseNowShowingViewModel @Inject constructor(
        getNowShowingMovies: GetNowShowingMovies,
        movieViewMapper: MovieViewMapper) : BrowseMovieViewModel(getNowShowingMovies, movieViewMapper)