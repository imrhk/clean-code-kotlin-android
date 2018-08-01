package com.litedevs.presentation.mapper

import com.litedevs.presentation.model.GenreView
import model.TGenre
import javax.inject.Inject

class GenreMapper @Inject constructor() : Mapper<GenreView, TGenre> {
    override fun mapToView(type: TGenre): GenreView {
        return GenreView(type.id, type.name)
    }
}