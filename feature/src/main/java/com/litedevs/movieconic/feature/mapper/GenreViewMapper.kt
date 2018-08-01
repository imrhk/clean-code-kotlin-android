package com.litedevs.movieconic.feature.mapper

import com.litedevs.movieconic.feature.model.Genre
import com.litedevs.presentation.model.GenreView
import javax.inject.Inject

class GenreViewMapper @Inject constructor() : ViewMapper<GenreView, Genre> {
    override fun mapToView(presentation: GenreView): Genre {
        return Genre(presentation.id, presentation.name)
    }
}