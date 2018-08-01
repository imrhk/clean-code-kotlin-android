package com.litedevs.domain.repository

import io.reactivex.Observable
import model.TMovie

interface MovieRepository {
    fun getTopMovies() : Observable<List<TMovie>>
    fun getRecentMovies() : Observable<List<TMovie>>
    fun getPopularMovies() : Observable<List<TMovie>>
    fun getLatestTrailers() : Observable<List<TMovie>>
    fun getNowShowingMovies() : Observable<List<TMovie>>
    fun getComingSoonMovies() : Observable<List<TMovie>>
}