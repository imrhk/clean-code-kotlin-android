package com.litedevs.data.mapper

import com.litedevs.data.model.CrewEntity
import model.TCrew
import javax.inject.Inject

class CrewMapper @Inject constructor() : EntityMapper<CrewEntity, TCrew> {
    override fun mapFromEntity(entity: CrewEntity): TCrew {
        return TCrew(entity.credit_id, entity.department, entity.gender, entity.id, entity.job, entity.name, entity.profile_path)
    }

    override fun entityToMap(map: TCrew): CrewEntity {
        return CrewEntity(map.credit_id, map.department, map.gender, map.id, map.job, map.name, map.profile_path)
    }
}