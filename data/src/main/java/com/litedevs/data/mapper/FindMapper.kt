package com.litedevs.data.mapper

import com.litedevs.data.model.FindEntity
import model.TFind
import javax.inject.Inject

class FindMapper @Inject constructor(
        private val movieMapper: MovieMapper) : EntityMapper<FindEntity, TFind> {
    override fun mapFromEntity(entity: FindEntity): TFind {
        return TFind(entity.movie_results?.let { Array(entity.movie_results.size) {movieMapper.mapFromEntity(entity.movie_results[it]) } })
    }

    override fun entityToMap(map: TFind): FindEntity {
        return FindEntity(map.movie_results.let { Array(map.movie_results!!.size) {movieMapper.entityToMap(map.movie_results!![it])} })
    }

}