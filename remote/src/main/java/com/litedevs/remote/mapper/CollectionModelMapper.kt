package com.litedevs.remote.mapper

import com.litedevs.data.model.CollectionEntity
import com.litedevs.data.model.MovieEntity
import com.litedevs.remote.model.CollectionModel
import javax.inject.Inject

class CollectionModelMapper @Inject constructor() : ModelMapper<CollectionModel, CollectionEntity> {

    lateinit var movieResponseModelMapper : MovieResponseModelMapper

    override fun mapFromModel(model: CollectionModel): CollectionEntity {
        val parts : Array<MovieEntity>? = model.parts?.let { Array(it.size, { i -> movieResponseModelMapper.mapFromModel(it[i])}) }
        return CollectionEntity(model.id, model.name, model.overview, model.poster_path, model.backdrop_path, parts)
    }

}