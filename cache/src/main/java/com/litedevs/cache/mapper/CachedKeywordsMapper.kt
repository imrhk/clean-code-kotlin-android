package com.litedevs.cache.mapper

import com.litedevs.cache.model.CachedKeyword
import com.litedevs.cache.model.CachedKeywords
import com.litedevs.data.model.KeywordEntity
import com.litedevs.data.model.KeywordsEntity
import javax.inject.Inject

class CachedKeywordMapper @Inject constructor() : CacheMapper<CachedKeyword, KeywordEntity> {
    override fun mapFromCached(type: CachedKeyword): KeywordEntity {
        return KeywordEntity(type.id, type.name)
    }

    override fun mapToCached(type: KeywordEntity): CachedKeyword {
        return CachedKeyword(type.id, type.name)
    }

}

class CachedKeywordsMapper @Inject constructor(private val cachedKeywordMapper: CachedKeywordMapper) : CacheMapper<CachedKeywords, KeywordsEntity> {
    override fun mapFromCached(type: CachedKeywords): KeywordsEntity {
        return KeywordsEntity(type.keywords?.let { Array(type.keywords.size) { cachedKeywordMapper.mapFromCached(type.keywords[it])} })
    }

    override fun mapToCached(type: KeywordsEntity): CachedKeywords {
        return CachedKeywords(type.keywords?.let { type.keywords!!.toList().map { cachedKeywordMapper.mapToCached(it) } })
    }
}