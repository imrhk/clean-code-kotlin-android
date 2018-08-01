package com.litedevs.movieconic.feature.mapper

import com.litedevs.movieconic.feature.model.Keyword
import com.litedevs.presentation.model.KeywordView
import javax.inject.Inject

class KeywordViewMapper @Inject constructor() : ViewMapper<KeywordView, Keyword> {
    override fun mapToView(presentation: KeywordView): Keyword {
        return Keyword(presentation.id, presentation.name)
    }
}