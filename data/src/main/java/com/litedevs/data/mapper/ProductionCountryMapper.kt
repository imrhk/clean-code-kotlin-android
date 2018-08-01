package com.litedevs.data.mapper

import com.litedevs.data.model.ProductionCountryEntity
import model.TProductionCountry
import javax.inject.Inject

class ProductionCountryMapper @Inject constructor() : EntityMapper<ProductionCountryEntity, TProductionCountry> {
    override fun mapFromEntity(entity: ProductionCountryEntity): TProductionCountry {
        return TProductionCountry(entity.iso_3166_1, entity.name)
    }

    override fun entityToMap(map: TProductionCountry): ProductionCountryEntity {
        return ProductionCountryEntity(map.iso_3166_1, map.name)
    }

}