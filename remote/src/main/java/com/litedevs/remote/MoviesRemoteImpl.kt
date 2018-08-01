package com.litedevs.remote

import com.litedevs.data.model.MovieEntity
import com.litedevs.data.repository.MovieRemote
import com.litedevs.remote.mapper.MovieResponseModelMapper
import com.litedevs.remote.service.TmdbApiService
import io.reactivex.Flowable
import javax.inject.Inject

class MoviesRemoteImpl @Inject constructor(
        private val service : TmdbApiService,
        private val mapper : MovieResponseModelMapper) : MovieRemote {
    override fun getTopMovies(): Flowable<List<MovieEntity>> = service.getList(634).map { it.items.map { mapper.mapFromModel(it) } }.map { it.asReversed() }

    override fun getLatestTrailers(): Flowable<List<MovieEntity>> = service.getList(9027).map{it.items.map { mapper.mapFromModel(it) } }

    override fun getComingSoonMovies(): Flowable<List<MovieEntity>> = service.getComingSoonMovies(1).map { it.items.map { mapper.mapFromModel(it) } }

    override fun getNowShowingMovies(): Flowable<List<MovieEntity>> = service.getNowPlayingMovies(1).map { it.items.map { mapper.mapFromModel(it) } }

    override fun getRecentMovies(): Flowable<List<MovieEntity>> = service.getList(932).map { it.items.map { mapper.mapFromModel(it) } }.map { it.asReversed() }

    override fun getPopularMovies(): Flowable<List<MovieEntity>> = service.getPopularMovies(1).map { it.items.map { mapper.mapFromModel(it) } }
}