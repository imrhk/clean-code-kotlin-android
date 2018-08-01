package com.litedevs.data.mapper

import com.litedevs.data.model.GenreEntity
import model.TGenre
import javax.inject.Inject

class GenreMapper @Inject constructor() : EntityMapper<GenreEntity, TGenre> {
    override fun mapFromEntity(entity: GenreEntity): TGenre {
        return TGenre(entity.id, entity.name)
    }

    override fun entityToMap(map: TGenre): GenreEntity {
        return GenreEntity(map.id, map.name)
    }

}