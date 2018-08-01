package com.litedevs.remote.mapper

import com.litedevs.data.model.KeywordEntity
import com.litedevs.data.model.KeywordsEntity
import com.litedevs.remote.model.KeywordModel
import com.litedevs.remote.model.KeywordsModel
import javax.inject.Inject

class KeywordModelMapper @Inject constructor() : ModelMapper<KeywordModel, KeywordEntity> {
    override fun mapFromModel(model: KeywordModel): KeywordEntity {
        return KeywordEntity(model.id, model.name)
    }
}

class KeywordsModelMapper @Inject constructor(
        private val keywordModelMapper: KeywordModelMapper) : ModelMapper<KeywordsModel, KeywordsEntity> {
    override fun mapFromModel(model: KeywordsModel): KeywordsEntity {
        return KeywordsEntity(model.keywords?.size?.let { Array(it, {keywordModelMapper.mapFromModel(model.keywords[it])}) })
    }
}