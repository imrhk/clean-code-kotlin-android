package com.litedevs.cache.mapper

import com.litedevs.cache.model.CachedCast
import com.litedevs.data.model.CastEntity
import javax.inject.Inject

class CachedCastMapper @Inject constructor() : CacheMapper<CachedCast, CastEntity> {
    override fun mapFromCached(type: CachedCast): CastEntity {
        return CastEntity(type.cast_id, type.character, type.credit_id, type.gender, type.cast_id, type.name, type.order, type.profile_path)
    }

    override fun mapToCached(type: CastEntity): CachedCast {
        return CachedCast(type.cast_id, type.character, type.credit_id, type.gender, type.cast_id, type.name, type.order, type.profile_path)
    }

}