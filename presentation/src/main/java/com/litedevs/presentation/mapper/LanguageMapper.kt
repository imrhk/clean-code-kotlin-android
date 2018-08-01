package com.litedevs.presentation.mapper

import com.litedevs.presentation.model.LanguageView
import model.TLanguage
import javax.inject.Inject

class LanguageMapper @Inject constructor() : Mapper<LanguageView, TLanguage> {
    override fun mapToView(type: TLanguage): LanguageView {
        return LanguageView(type.iso_639_1, type.name)
    }
}