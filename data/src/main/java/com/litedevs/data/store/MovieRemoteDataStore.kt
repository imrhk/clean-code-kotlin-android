package com.litedevs.data.store

import com.litedevs.data.model.MovieEntity
import com.litedevs.data.repository.MovieDataStore
import com.litedevs.data.repository.MovieRemote
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class MovieRemoteDataStore @Inject constructor(
        private val movieRemote: MovieRemote) : MovieDataStore {
    override fun getTopMovies(): Flowable<List<MovieEntity>> {
        return movieRemote.getTopMovies()
    }

    override fun getLatestTrailers(): Flowable<List<MovieEntity>> {
        return movieRemote.getLatestTrailers()
    }

    override fun getComingSoonMovies(): Flowable<List<MovieEntity>> {
        return movieRemote.getComingSoonMovies()
    }

    override fun getNowShowingMovies(): Flowable<List<MovieEntity>> {
        return movieRemote.getNowShowingMovies()
    }

    override fun getRecentMovies(): Flowable<List<MovieEntity>> {
        return movieRemote.getRecentMovies()
    }

    override fun getPopularMovies(): Flowable<List<MovieEntity>> {
        return movieRemote.getPopularMovies()
    }

    override fun saveTopMovies(movies: List<MovieEntity>): Completable {
        throw UnsupportedOperationException("Not supported here")
    }

    override fun savePopularMovies(movies: List<MovieEntity>): Completable {
        throw UnsupportedOperationException("Not supported here")
    }

    override fun saveNowShowingMovies(movies: List<MovieEntity>): Completable {
        throw UnsupportedOperationException("Not supported here")
    }

    override fun saveRecentMovies(movies: List<MovieEntity>): Completable {
        throw UnsupportedOperationException("Not supported here")
    }

    override fun saveComingSoonMovies(movies: List<MovieEntity>): Completable {
        throw UnsupportedOperationException("Not supported here")
    }

    override fun saveLatestTrailers(movies: List<MovieEntity>): Completable {
        throw UnsupportedOperationException("Not supported here")
    }

    override fun clearTopMovies(): Completable {
        throw UnsupportedOperationException("Not supported here")
    }

    override fun clearPopularMovies(): Completable {
        throw UnsupportedOperationException("Not supported here")
    }

    override fun clearNowShowingMovies(): Completable {
        throw UnsupportedOperationException("Not supported here")
    }

    override fun clearRecentMovies(): Completable {
        throw UnsupportedOperationException("Not supported here")
    }

    override fun clearComingSoonMovies(): Completable {
        throw UnsupportedOperationException("Not supported here")
    }

    override fun clearLatestTrailers(): Completable {
        throw UnsupportedOperationException("Not supported here")
    }

    override fun clearMovies(): Completable {
        throw UnsupportedOperationException("Not supported here")
    }
}