package com.litedevs.data.mapper

import com.litedevs.data.model.CastEntity
import model.TCast
import javax.inject.Inject

class CastMapper @Inject constructor() : EntityMapper<CastEntity, TCast> {
    override fun mapFromEntity(entity: CastEntity): TCast {
        return TCast(entity.cast_id, entity.character, entity.credit_id, entity.gender, entity.cast_id, entity.name, entity.order, entity.profile_path)
    }

    override fun entityToMap(map: TCast): CastEntity {
        return CastEntity(map.cast_id, map.character, map.credit_id, map.gender, map.cast_id, map.name, map.order, map.profile_path)
    }
}