package com.litedevs.cache.mapper

import com.litedevs.cache.model.CachedProductionCountry
import com.litedevs.data.model.ProductionCountryEntity
import javax.inject.Inject

class CachedProductionCountryMapper @Inject constructor() : CacheMapper<CachedProductionCountry, ProductionCountryEntity> {
    override fun mapFromCached(type: CachedProductionCountry): ProductionCountryEntity {
        return ProductionCountryEntity(type.iso_3166_1, type.name)
    }

    override fun mapToCached(type: ProductionCountryEntity): CachedProductionCountry {
        return CachedProductionCountry(type.iso_3166_1, type.name)
    }
}