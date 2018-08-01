package com.litedevs.data.repository

import com.litedevs.data.model.MovieEntity
import io.reactivex.Flowable

interface MovieRemote {
    fun getTopMovies() : Flowable<List<MovieEntity>>
    fun getLatestTrailers() : Flowable<List<MovieEntity>>
    fun getComingSoonMovies() : Flowable<List<MovieEntity>>
    fun getNowShowingMovies() : Flowable<List<MovieEntity>>
    fun getRecentMovies() : Flowable<List<MovieEntity>>
    fun getPopularMovies() : Flowable<List<MovieEntity>>
}