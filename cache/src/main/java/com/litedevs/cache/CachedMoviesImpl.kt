package com.litedevs.cache

import android.util.Log
import com.litedevs.cache.db.MovieDatabase
import com.litedevs.cache.mapper.CachedMovieMapper
import com.litedevs.cache.model.CachedMovieList
import com.litedevs.data.model.MovieEntity
import com.litedevs.data.repository.MoviesCache
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

class CachedMoviesImpl @Inject constructor(
        private val movieDatabase: MovieDatabase,
        private val mapper : CachedMovieMapper) : MoviesCache {
    override fun setLastCacheTime(category: String, lastTime: Long): Completable {
        return Completable.defer{
                movieDatabase.cachedMovieListDao().setCacheTime(lastTime, category)
            Completable.complete()
        }
    }

    override fun areMoviesCached(category: String): Single<Boolean> {
        return movieDatabase.cachedMovieListDao()
                .getMovieList(category)
                .onErrorReturn {
                    listOf(CachedMovieList(movies = Collections.emptyList(), type = category, lastCacheTime = 0L)) }
                .firstOrError()
                .map {
                    if(it.size == 0)
                        false
                    else it.get(0).movies.isNotEmpty()
                }
    }

    override fun isMovieCacheExpired(category: String): Single<Boolean> {
        return movieDatabase.cachedMovieListDao()
                .getMovieList(category)
                .onErrorReturn { listOf(CachedMovieList(Collections.emptyList(), type = category, lastCacheTime = 0L)) }
                .firstOrError()
                .map {
                    if(it.size == 0) true
                    else {
                        it.get(0).lastCacheTime < System.currentTimeMillis() - (8 * 60 * 60 * 1000).toLong()
                    }
                }
    }

    override fun clearCache(category: String?): Completable {
        return Completable.defer{
            if (category != null) {
                movieDatabase.cachedMovieListDao().clearMovieList(category)
            }
            Completable.complete()
        }
    }

    private fun saveMovies(movies: Array<MovieEntity>, type : String) : Completable {
        return Completable.defer {
            movieDatabase.cachedMovieListDao().setMovies(CachedMovieList(movies.asList().map { mapper.mapToCached(it)}, type,
                    System.currentTimeMillis()))
            Completable.complete()
        }
    }

    override fun saveTopMovies(movies: Array<MovieEntity>): Completable {
        return saveMovies(movies, "top")
    }

    override fun savePopularMovies(movies: Array<MovieEntity>): Completable {
        return saveMovies(movies, "popular")
    }

    override fun saveNowShowingMovies(movies: Array<MovieEntity>): Completable {
        return saveMovies(movies, "now_showing")
    }

    override fun saveRecentMovies(movies: Array<MovieEntity>): Completable {
        return saveMovies(movies, "recent")
    }

    override fun saveComingSoonMovies(movies: Array<MovieEntity>): Completable {
        return saveMovies(movies, "coming_soon")
    }

    override fun saveLatestTrailers(movies: Array<MovieEntity>): Completable {
        return saveMovies(movies, "trailers")
    }

    private fun getMovies(type: String) : Flowable<List<MovieEntity>> {
        return movieDatabase.cachedMovieListDao().getMovieList(type)
                .distinctUntilChanged()
                .map { it.get(0) }
                .map { it.movies.map { mapper.mapFromCached(it) } }
    }

    override fun getTopMovies(): Flowable<List<MovieEntity>> {
        return getMovies("top")
    }

    override fun getLatestTrailers(): Flowable<List<MovieEntity>> {
        return getMovies("trailers")
    }

    override fun getComingSoonMovies(): Flowable<List<MovieEntity>> {
        return getMovies("coming_soon")
    }

    override fun getNowShowingMovies(): Flowable<List<MovieEntity>> {
        return getMovies("now_showing")
    }

    override fun getRecentMovies(): Flowable<List<MovieEntity>> {
        return getMovies("recent")
    }

    override fun getPopularMovies(): Flowable<List<MovieEntity>> {
        return getMovies("popular")
    }
}