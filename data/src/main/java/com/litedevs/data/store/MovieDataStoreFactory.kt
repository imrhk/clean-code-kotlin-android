package com.litedevs.data.store

import com.litedevs.data.repository.MovieDataStore
import javax.inject.Inject

class MovieDataStoreFactory @Inject constructor(
        val movieCacheDataStore: MovieCacheDataStore,
        val movieRemoteDataStore: MovieRemoteDataStore) {

    fun getDataStore(movieCached : Boolean, cachedExpired : Boolean) : MovieDataStore {
        return if(!movieCached || cachedExpired) {
            movieRemoteDataStore
        }
        else{
            movieCacheDataStore
        }
    }


    fun getCacheDataStore() = movieCacheDataStore
}