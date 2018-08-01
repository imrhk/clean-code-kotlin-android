package com.litedevs.cache.mapper

import com.litedevs.cache.model.CachedFind
import com.litedevs.data.model.FindEntity
import javax.inject.Inject

class CachedFindMapper @Inject constructor(private val movieMapper: CachedMovieMapper) : CacheMapper<CachedFind, FindEntity> {
    override fun mapFromCached(type: CachedFind): FindEntity {
        return FindEntity(type.movie_results?.let { Array(type.movie_results.size){it->movieMapper.mapFromCached(type.movie_results[it])}})
    }

    override fun mapToCached(type: FindEntity): CachedFind {
        return CachedFind( type.movie_results?.let{ type.movie_results!!.toList().map { movieMapper.mapToCached(it) } })
    }

}