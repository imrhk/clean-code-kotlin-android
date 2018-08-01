package com.litedevs.presentation.mapper

import com.litedevs.presentation.model.KeywordView
import model.TKeyword
import javax.inject.Inject

class KeywordMapper @Inject constructor() : Mapper<KeywordView, TKeyword> {
    override fun mapToView(type: TKeyword): KeywordView {
        return KeywordView(type.id, type.name)
    }
}