package com.litedevs.presentation.mapper

import com.litedevs.presentation.model.CollectionView
import model.TCollection
import model.TMovie
import javax.inject.Inject

class CollectionMapper @Inject constructor() : Mapper<CollectionView, TCollection> {

    lateinit var movieViewMapper: MovieViewMapper

    override fun mapToView(type: TCollection): CollectionView {
        return CollectionView(type.id, type.name, type.overview, type.poster_path, type.backdrop_path,
                type.parts?.let { Array(type.parts!!.size) { movieViewMapper.mapToView(type.parts!![it])} })
    }
}