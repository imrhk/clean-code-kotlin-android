package com.litedevs.remote.mapper

import com.litedevs.data.model.GenreEntity
import com.litedevs.remote.model.GenreModel
import javax.inject.Inject

class GenreModelMapper @Inject constructor() : ModelMapper<GenreModel, GenreEntity> {
    override fun mapFromModel(model: GenreModel): GenreEntity {
        return GenreEntity(model.id, model.name)
    }
}