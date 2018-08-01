package com.litedevs.data.store

import com.litedevs.data.model.MovieEntity
import com.litedevs.data.repository.MoviesCache
import com.litedevs.data.repository.MovieDataStore
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class MovieCacheDataStore @Inject constructor(
        private val movieCache: MoviesCache) : MovieDataStore {
    override fun getTopMovies(): Flowable<List<MovieEntity>> {
        return movieCache.getTopMovies()
    }

    override fun getLatestTrailers(): Flowable<List<MovieEntity>> {
        return movieCache.getLatestTrailers()
    }

    override fun getComingSoonMovies(): Flowable<List<MovieEntity>> {
        return movieCache.getComingSoonMovies()
    }

    override fun getNowShowingMovies(): Flowable<List<MovieEntity>> {
        return movieCache.getNowShowingMovies()
    }

    override fun getRecentMovies(): Flowable<List<MovieEntity>> {
        return movieCache.getRecentMovies()
    }

    override fun getPopularMovies(): Flowable<List<MovieEntity>> {
        return movieCache.getPopularMovies()
    }

    override fun saveTopMovies(movies: List<MovieEntity>): Completable {
        return movieCache.saveTopMovies(Array(movies.size) { it -> movies[it] })
    }

    override fun savePopularMovies(movies: List<MovieEntity>): Completable {
        return movieCache.savePopularMovies(Array(movies.size) { it -> movies[it] })
    }

    override fun saveNowShowingMovies(movies: List<MovieEntity>): Completable {
        return movieCache.saveNowShowingMovies(Array(movies.size) { it -> movies[it] })
    }

    override fun saveRecentMovies(movies: List<MovieEntity>): Completable {
        return movieCache.saveRecentMovies(Array(movies.size) { it -> movies[it] })
    }

    override fun saveComingSoonMovies(movies: List<MovieEntity>): Completable {
        return movieCache.saveComingSoonMovies(Array(movies.size) { it -> movies[it] })
    }

    override fun saveLatestTrailers(movies: List<MovieEntity>): Completable {
        return movieCache.saveLatestTrailers(Array(movies.size) { it -> movies[it] })
    }

    override fun clearTopMovies(): Completable {
        return movieCache.clearCache("top")
    }

    override fun clearPopularMovies(): Completable {
        return movieCache.clearCache("popular")
    }

    override fun clearNowShowingMovies(): Completable {
        return movieCache.clearCache("now_showing")
    }

    override fun clearRecentMovies(): Completable {
        return movieCache.clearCache("recent")
    }

    override fun clearComingSoonMovies(): Completable {
        return movieCache.clearCache("coming_soon")
    }

    override fun clearLatestTrailers(): Completable {
        return movieCache.clearCache("latest_trailers")
    }

    override fun clearMovies(): Completable {
        return movieCache.clearCache()
    }
}