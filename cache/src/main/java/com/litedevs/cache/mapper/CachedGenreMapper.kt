package com.litedevs.cache.mapper

import com.litedevs.cache.model.CachedGenre
import com.litedevs.data.model.GenreEntity
import javax.inject.Inject

class CachedGenreMapper @Inject constructor() : CacheMapper<CachedGenre,GenreEntity> {
    override fun mapFromCached(type: CachedGenre): GenreEntity {
        return GenreEntity(type.id, type.name)
    }

    override fun mapToCached(type: GenreEntity): CachedGenre {
        return CachedGenre(type.id, type.name)
    }
}