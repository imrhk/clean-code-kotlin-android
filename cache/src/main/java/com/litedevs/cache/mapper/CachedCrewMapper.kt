package com.litedevs.cache.mapper

import com.litedevs.cache.model.CachedCrew
import com.litedevs.data.model.CrewEntity
import javax.inject.Inject

class CachedCrewMapper @Inject constructor() : CacheMapper<CachedCrew, CrewEntity> {
    override fun mapFromCached(type: CachedCrew): CrewEntity {
        return CrewEntity(type.credit_id, type.department, type.gender, type.id, type.job, type.name, type.profile_path)
    }

    override fun mapToCached(type: CrewEntity): CachedCrew {
        return CachedCrew(type.credit_id, type.department, type.gender, type.id, type.job, type.name, type.profile_path)
    }
}