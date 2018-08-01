package com.litedevs.movieconic.feature.mapper

import com.litedevs.movieconic.feature.model.Language
import com.litedevs.presentation.model.LanguageView
import javax.inject.Inject

class LanguageViewMapper @Inject constructor() : ViewMapper<LanguageView, Language> {
    override fun mapToView(presentation: LanguageView): Language {
        return Language(presentation.iso_639_1, presentation.name)
    }
}