package com.litedevs.data.mapper

import com.litedevs.data.model.CreditEntity
import model.TCredit
import javax.inject.Inject

class CreditMapper @Inject constructor(
        private val castMapper: CastMapper,
        private val crewMapper: CrewMapper) : EntityMapper<CreditEntity, TCredit> {
    override fun mapFromEntity(entity: CreditEntity): TCredit {
        return TCredit(
                entity.cast?.let{Array(entity.cast.size) { castMapper.mapFromEntity(entity.cast[it])} },
                entity.crew?.let{Array(entity.crew.size) { crewMapper.mapFromEntity(entity.crew[it])} })
    }

    override fun entityToMap(map: TCredit): CreditEntity {
        return CreditEntity(map.cast?.let { Array(map.cast!!.size) { castMapper.entityToMap(map.cast!![it])} },
                map.crew?.let { Array(map.crew!!.size) { crewMapper.entityToMap(map.crew!![it])} })
    }

}
