package com.litedevs.remote.mapper

import com.litedevs.data.model.ProductionCountryEntity
import com.litedevs.remote.model.ProductionCountryModel
import javax.inject.Inject

class ProductionCountryModelMapper @Inject constructor() : ModelMapper<ProductionCountryModel, ProductionCountryEntity> {
    override fun mapFromModel(model: ProductionCountryModel): ProductionCountryEntity {
        return ProductionCountryEntity(model.iso_3166_1, model.name)
    }
}