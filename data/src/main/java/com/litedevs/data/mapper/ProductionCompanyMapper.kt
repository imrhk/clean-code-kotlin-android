package com.litedevs.data.mapper

import com.litedevs.data.model.ProductionCompanyEntity
import model.TProductionCompany
import javax.inject.Inject

class ProductionCompanyMapper @Inject constructor() : EntityMapper<ProductionCompanyEntity, TProductionCompany> {
    override fun mapFromEntity(entity: ProductionCompanyEntity): TProductionCompany {
        return TProductionCompany(entity.description, entity.headquarters, entity.homepage, entity.id, entity.logo_path, entity.name, entity.origin_country,
                entity.parent_company?.let { mapFromEntity(entity.parent_company)})
    }

    override fun entityToMap(map: TProductionCompany): ProductionCompanyEntity {
        return ProductionCompanyEntity(map.description, map.headquarters, map.homepage, map.id, map.logo_path, map.name, map.origin_country, map.parent_company?.let { entityToMap(map.parent_company!!)})
    }
}