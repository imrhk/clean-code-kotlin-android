package com.litedevs.movieconic.feature.mapper

import com.litedevs.movieconic.feature.model.Collection
import com.litedevs.presentation.model.CollectionView
import javax.inject.Inject

class CollectionViewMapper @Inject constructor() : ViewMapper<CollectionView, Collection> {

    lateinit var movieViewMapper : MovieViewMapper

    override fun mapToView(presentation: CollectionView): Collection {
        return Collection(presentation.id, presentation.name, presentation.overview, presentation.poster_path, presentation.backdrop_path,
                presentation.parts?.let { Array(presentation.parts!!.size) { movieViewMapper.mapToView(presentation.parts!![it]) } })

    }
}