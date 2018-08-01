package com.litedevs.presentation.browse

import com.litedevs.domain.interactor.browse.GetLatestTrailers
import com.litedevs.domain.interactor.browse.GetNowShowingMovies
import com.litedevs.domain.interactor.browse.GetRecentMovies
import com.litedevs.presentation.mapper.MovieViewMapper
import javax.inject.Inject

class BrowseLatestTrailersViewModel @Inject constructor(
        getLatestTrailers: GetLatestTrailers,
        movieViewMapper: MovieViewMapper) : BrowseMovieViewModel(getLatestTrailers, movieViewMapper)