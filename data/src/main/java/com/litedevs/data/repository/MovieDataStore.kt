package com.litedevs.data.repository

import com.litedevs.data.model.MovieEntity
import io.reactivex.Completable
import io.reactivex.Flowable

interface MovieDataStore {
    fun getTopMovies() : Flowable<List<MovieEntity>>
    fun getLatestTrailers() : Flowable<List<MovieEntity>>
    fun getComingSoonMovies() : Flowable<List<MovieEntity>>
    fun getNowShowingMovies() : Flowable<List<MovieEntity>>
    fun getRecentMovies() : Flowable<List<MovieEntity>>
    fun getPopularMovies() : Flowable<List<MovieEntity>>

    fun saveTopMovies(movies : List<MovieEntity>) : Completable
    fun savePopularMovies(movies : List<MovieEntity>) : Completable
    fun saveNowShowingMovies(movies : List<MovieEntity>) : Completable
    fun saveRecentMovies(movies : List<MovieEntity>) : Completable
    fun saveComingSoonMovies(movies : List<MovieEntity>) : Completable
    fun saveLatestTrailers(movies : List<MovieEntity>) : Completable

    fun clearTopMovies() : Completable
    fun clearPopularMovies() : Completable
    fun clearNowShowingMovies() : Completable
    fun clearRecentMovies() : Completable
    fun clearComingSoonMovies() : Completable
    fun clearLatestTrailers() : Completable
    fun clearMovies() : Completable
}