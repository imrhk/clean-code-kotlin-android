package com.litedevs.cache.mapper

import com.litedevs.cache.model.CachedLanguage
import com.litedevs.data.model.LanguageEntity
import javax.inject.Inject

class CachedLanguageMapper @Inject constructor() : CacheMapper<CachedLanguage, LanguageEntity> {
    override fun mapFromCached(type: CachedLanguage): LanguageEntity {
        return LanguageEntity(type.iso_639_1, type.name)
    }

    override fun mapToCached(type: LanguageEntity): CachedLanguage {
        return CachedLanguage(type.iso_639_1, type.name)
    }
}