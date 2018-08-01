package com.litedevs.presentation.mapper

import com.litedevs.presentation.model.KeywordsView
import model.TKeywords
import javax.inject.Inject

class KeywordsMapper @Inject constructor(private val keywordMapper: KeywordMapper) : Mapper<KeywordsView, TKeywords> {
    override fun mapToView(type: TKeywords): KeywordsView {
        return KeywordsView(type.keywords?.size?.let { Array(it) { it -> keywordMapper.mapToView(type.keywords!![it]) } })
    }
}