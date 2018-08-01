package com.litedevs.remote.mapper

import com.litedevs.data.model.CastEntity
import com.litedevs.remote.model.CastModel
import javax.inject.Inject

class CastModelMapper @Inject constructor() : ModelMapper<CastModel, CastEntity> {
    override fun mapFromModel(model: CastModel): CastEntity {
        return CastEntity(model.cast_id, model.character, model.credit_id, model.gender, model.cast_id, model.name, model.order, model.profile_path)
    }
}