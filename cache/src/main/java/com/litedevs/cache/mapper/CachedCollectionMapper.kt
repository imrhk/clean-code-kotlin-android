package com.litedevs.cache.mapper

import com.litedevs.cache.model.CachedCollection
import com.litedevs.data.model.CollectionEntity
import javax.inject.Inject

class CachedCollectionMapper @Inject constructor() : CacheMapper<CachedCollection, CollectionEntity> {

    lateinit var cachedMovieMapper: CachedMovieMapper

    override fun mapFromCached(type: CachedCollection): CollectionEntity {
        return CollectionEntity(type.id, type.name, type.overview, type.poster_path, type.backdrop_path,
                type.parts?.let { Array(type.parts.size) { cachedMovieMapper.mapFromCached(type.parts[it]) } })
    }

    override fun mapToCached(type: CollectionEntity): CachedCollection {
        return CachedCollection(type.id, type.name, type.overview, type.poster_path, type.backdrop_path,
                type.parts?.let{ type.parts!!.toList().map { cachedMovieMapper.mapToCached(it) } })

    }

}