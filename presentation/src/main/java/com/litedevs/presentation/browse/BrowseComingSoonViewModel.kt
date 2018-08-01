package com.litedevs.presentation.browse

import com.litedevs.domain.interactor.browse.GetComingSoonMovies
import com.litedevs.presentation.mapper.MovieViewMapper
import javax.inject.Inject

class BrowseComingSoonViewModel @Inject constructor(
        getComingSoonMovies: GetComingSoonMovies,
        movieViewMapper: MovieViewMapper) : BrowseMovieViewModel(getComingSoonMovies, movieViewMapper)