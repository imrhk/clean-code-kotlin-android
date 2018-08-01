package com.litedevs.data.mapper

import com.litedevs.data.model.CollectionEntity
import model.TCollection
import javax.inject.Inject

class CollectionMapper @Inject constructor() : EntityMapper<CollectionEntity, TCollection> {

    lateinit var movieMapper : MovieMapper

    override fun mapFromEntity(entity: CollectionEntity): TCollection {

        return TCollection(entity.id, entity.name, entity.overview, entity.poster_path, entity.backdrop_path,
                movieMapper.let{entity.parts?.let { Array(entity.parts.size) { movieMapper.mapFromEntity(entity.parts[it]) } }})
    }

    override fun entityToMap(map: TCollection): CollectionEntity {
        return CollectionEntity(map.id, map.name, map.overview, map.poster_path, map.backdrop_path,
                movieMapper.let { map.parts?.let { Array(map.parts!!.size) { movieMapper.entityToMap(map.parts!![it])} }})
    }

}