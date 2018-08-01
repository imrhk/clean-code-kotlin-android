package com.litedevs.data

import com.litedevs.data.mapper.MovieMapper
import com.litedevs.data.repository.MoviesCache
import com.litedevs.data.store.MovieDataStoreFactory
import com.litedevs.domain.repository.MovieRepository
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Consumer
import model.TMovie
import javax.inject.Inject

class MovieDataRepository @Inject constructor(
        private val movieMapper : MovieMapper,
        private val cache : MoviesCache,
        private val factory : MovieDataStoreFactory) : MovieRepository {
    override fun getTopMovies(): Observable<List<TMovie>> {
        val moviesCachedObservable : Observable<Boolean> = cache.areMoviesCached("top").toObservable()
        val moviesCachedExpiredObservable : Observable<Boolean> = cache.isMovieCacheExpired("top").toObservable()

        return Observable.zip(moviesCachedObservable,
                moviesCachedExpiredObservable,
                BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> { areCached, isExpired ->
                    Pair(areCached, isExpired)
                })
                .flatMap { it ->
                    factory.getDataStore(it.first, it.second).getTopMovies().toObservable()
                            .distinctUntilChanged()
                }
                .flatMap { movies ->
                    factory.getCacheDataStore()
                            .saveTopMovies(movies)
                            .andThen(Observable.just(movies))
                }
                .map {
                    it.map {
                        movieMapper.mapFromEntity(it)
                    }
                }
    }

    override fun getRecentMovies(): Observable<List<TMovie>> {
        val moviesCachedObservable : Observable<Boolean> = cache.areMoviesCached("recent").toObservable()
        val moviesCachedExpiredObservable : Observable<Boolean> = cache.isMovieCacheExpired("recent").toObservable()

        return Observable.zip(moviesCachedObservable,
                moviesCachedExpiredObservable,
                BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> { areCached, isExpired ->
                    Pair(areCached, isExpired)
                })
                .flatMap { it ->
                    factory.getDataStore(it.first, it.second).getRecentMovies().toObservable()
                            .distinctUntilChanged()
                }
                .flatMap { movies ->
                    factory.getCacheDataStore()
                            .saveRecentMovies(movies)
                            .andThen(Observable.just(movies))
                }
                .map {
                    it.map {
                        movieMapper.mapFromEntity(it)
                    }
                }
    }

    override fun getPopularMovies(): Observable<List<TMovie>> {
        val moviesCachedObservable : Observable<Boolean> = cache.areMoviesCached("popular").toObservable()
        val moviesCachedExpiredObservable : Observable<Boolean> = cache.isMovieCacheExpired("popular").toObservable()

        return Observable.zip(moviesCachedObservable,
                moviesCachedExpiredObservable,
                BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> { areCached, isExpired ->
                    Pair(areCached, isExpired)
                })
                .flatMap { it ->
                    factory.getDataStore(it.first, it.second).getPopularMovies().toObservable()
                            .distinctUntilChanged()
                }
                .flatMap { movies ->
                    factory.getCacheDataStore()
                            .savePopularMovies(movies)
                            .andThen(Observable.just(movies))
                }
                .map {
                    it.map { movieEntity ->
                        movieMapper.mapFromEntity(movieEntity)
                    }
                }
    }

    override fun getLatestTrailers(): Observable<List<TMovie>> {
        val moviesCachedObservable : Observable<Boolean> = cache.areMoviesCached("trailers").toObservable()
        val moviesCachedExpiredObservable : Observable<Boolean> = cache.isMovieCacheExpired("trailers").toObservable()

        return Observable.zip(moviesCachedObservable,
                moviesCachedExpiredObservable,
                BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> { areCached, isExpired ->
                    Pair(areCached, isExpired)
                })
                .flatMap { it ->
                    factory.getDataStore(it.first, it.second).getLatestTrailers().toObservable()
                            .distinctUntilChanged()
                }
                .flatMap { movies ->
                    factory.getCacheDataStore()
                            .saveLatestTrailers(movies)
                            .andThen(Observable.just(movies))
                }
                .map {
                    it.map {
                        movieMapper.mapFromEntity(it)
                    }
                }
    }

    override fun getNowShowingMovies(): Observable<List<TMovie>> {
        val moviesCachedObservable : Observable<Boolean> = cache.areMoviesCached("now_showing").toObservable()
        val moviesCachedExpiredObservable : Observable<Boolean> = cache.isMovieCacheExpired("now_showing").toObservable()

        return Observable.zip(moviesCachedObservable,
                moviesCachedExpiredObservable,
                BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> { areCached, isExpired ->
                    Pair(areCached, isExpired)
                })
                .flatMap { it ->
                    factory.getDataStore(it.first, it.second).getNowShowingMovies().toObservable()
                            .distinctUntilChanged()
                }
                .flatMap { movies ->
                    factory.getCacheDataStore()
                            .saveNowShowingMovies(movies)
                            .andThen(Observable.just(movies))
                }
                .map {
                    it.map {
                        movieMapper.mapFromEntity(it)
                    }
                }
    }

    override fun getComingSoonMovies(): Observable<List<TMovie>> {
        val moviesCachedObservable : Observable<Boolean> = cache.areMoviesCached("coming_soon").toObservable()
        val moviesCachedExpiredObservable : Observable<Boolean> = cache.isMovieCacheExpired("coming_soon").toObservable()

        return Observable.zip(moviesCachedObservable,
                moviesCachedExpiredObservable,
                BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> { areCached, isExpired ->
                    Pair(areCached, isExpired)
                })
                .flatMap { it ->
                    factory.getDataStore(it.first, it.second).getComingSoonMovies().toObservable()
                            .distinctUntilChanged()
                }
                .flatMap { movies ->
                    factory.getCacheDataStore()
                            .saveComingSoonMovies(movies)
                            .andThen(Observable.just(movies))
                }
                .map {
                    it.map {
                        movieMapper.mapFromEntity(it)
                    }
                }
    }

}