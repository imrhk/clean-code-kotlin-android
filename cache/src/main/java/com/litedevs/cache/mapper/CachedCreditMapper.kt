package com.litedevs.cache.mapper

import com.litedevs.cache.model.CachedCredit
import com.litedevs.data.model.CreditEntity
import javax.inject.Inject

class CachedCreditMapper @Inject constructor(
        private val castMapper: CachedCastMapper,
        private val crewMapper: CachedCrewMapper) : CacheMapper<CachedCredit, CreditEntity> {
    override fun mapFromCached(type: CachedCredit): CreditEntity {
        return CreditEntity(type.cast?.let { Array(type.cast.size) { it -> castMapper.mapFromCached(type.cast[it]) } },
                type.crew?.let { Array(type.crew.size) { crewMapper.mapFromCached(type.crew[it]) } })
    }

    override fun mapToCached(type: CreditEntity): CachedCredit {
        return CachedCredit(type.cast?.let{ type.cast!!.toList().map { castMapper.mapToCached(it) } },
                type.crew?.let{ type.crew!!.toList().map { crewMapper.mapToCached(it) } })
    }
}