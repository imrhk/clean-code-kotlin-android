package com.litedevs.cache.mapper

import com.litedevs.cache.model.CachedProductionCompany
import com.litedevs.data.model.ProductionCompanyEntity
import javax.inject.Inject

class CachedProductionCompanyMapper @Inject constructor() : CacheMapper<CachedProductionCompany, ProductionCompanyEntity> {
    override fun mapFromCached(type: CachedProductionCompany): ProductionCompanyEntity {
        return ProductionCompanyEntity(type.description, type.headquarters, type.homepage, type.id, type.logo_path, type.name, type.origin_country, type.parent_company?.let { mapFromCached(it) })
    }

    override fun mapToCached(type: ProductionCompanyEntity): CachedProductionCompany {
        return CachedProductionCompany(type.description, type.headquarters, type.homepage, type.id, type.logo_path, type.name, type.origin_country, type.parent_company?.let { mapToCached(it) })
    }
}