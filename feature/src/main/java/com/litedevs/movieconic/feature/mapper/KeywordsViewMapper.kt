package com.litedevs.movieconic.feature.mapper

import com.litedevs.movieconic.feature.model.Keyword
import com.litedevs.movieconic.feature.model.Keywords
import com.litedevs.presentation.model.KeywordsView
import java.util.*
import javax.inject.Inject

class KeywordsViewMapper @Inject constructor(private val keywordViewMapper: KeywordViewMapper) : ViewMapper<KeywordsView, Keywords> {
    override fun mapToView(presentation: KeywordsView): Keywords {
        return if (presentation.keywords == null)
            Keywords(null)
        else presentation.keywords?.let{
            Keywords(Array(presentation.keywords!!.size) { it -> keywordViewMapper.mapToView(presentation.keywords!![it])  })}!!
    }
}