package com.litedevs.data.repository

import com.litedevs.data.model.MovieEntity
import io.reactivex.Completable
import io.reactivex.Single

interface MoviesCache : MovieRemote{
    fun setLastCacheTime(category: String, lastTime : Long) : Completable
    fun areMoviesCached(category : String) : Single<Boolean>
    fun isMovieCacheExpired(category: String) : Single<Boolean>
    fun clearCache(category: String? = null) : Completable

    fun saveTopMovies(movies : Array<MovieEntity>) : Completable
    fun savePopularMovies(movies : Array<MovieEntity>) : Completable
    fun saveNowShowingMovies(movies : Array<MovieEntity>) : Completable
    fun saveRecentMovies(movies : Array<MovieEntity>) : Completable
    fun saveComingSoonMovies(movies : Array<MovieEntity>) : Completable
    fun saveLatestTrailers(movies : Array<MovieEntity>) : Completable
}