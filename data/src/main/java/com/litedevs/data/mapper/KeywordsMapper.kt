package com.litedevs.data.mapper

import com.litedevs.data.model.KeywordEntity
import com.litedevs.data.model.KeywordsEntity
import model.TKeyword
import model.TKeywords
import javax.inject.Inject

class KeywordMapper @Inject constructor() : EntityMapper<KeywordEntity, TKeyword> {
    override fun mapFromEntity(entity: KeywordEntity): TKeyword {
        return TKeyword(entity.id, entity.name)
    }

    override fun entityToMap(map: TKeyword): KeywordEntity {
        return KeywordEntity(map.id, map.name)
    }
}

class KeywordsMapper @Inject constructor(
        private val keywordMapper: KeywordMapper) : EntityMapper<KeywordsEntity, TKeywords> {
    override fun mapFromEntity(entity: KeywordsEntity): TKeywords {
        return TKeywords(entity.keywords?.let { Array(entity.keywords.size) { keywordMapper.mapFromEntity(entity.keywords[it])} })
    }

    override fun entityToMap(map: TKeywords): KeywordsEntity {
        return KeywordsEntity(map.keywords?.let { Array(map.keywords!!.size) { keywordMapper.entityToMap(map.keywords!![it])} })
    }

}