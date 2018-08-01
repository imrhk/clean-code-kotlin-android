package com.litedevs.remote.mapper

import com.litedevs.data.model.CreditEntity
import com.litedevs.remote.model.CreditModel
import javax.inject.Inject

class CreditModelMapper @Inject constructor(
        private val castModelMapper: CastModelMapper,
        private val crewModelMapper: CrewModelMapper) : ModelMapper<CreditModel, CreditEntity>{
    override fun mapFromModel(model: CreditModel): CreditEntity {
        return CreditEntity(model.cast?.size?.let { Array(it, { it -> castModelMapper.mapFromModel(model.cast[it])}) },
                model.crew?.size?.let { Array(it, { it -> crewModelMapper.mapFromModel(model.crew[it])}) })
    }

}
