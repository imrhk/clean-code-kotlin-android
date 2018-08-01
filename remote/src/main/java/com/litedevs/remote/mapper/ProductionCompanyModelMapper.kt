package com.litedevs.remote.mapper

import com.litedevs.data.model.ProductionCompanyEntity
import com.litedevs.remote.model.ProductionCompanyModel
import javax.inject.Inject

class ProductionCompanyModelMapper @Inject constructor() : ModelMapper<ProductionCompanyModel, ProductionCompanyEntity> {
    override fun mapFromModel(model: ProductionCompanyModel): ProductionCompanyEntity {
        return ProductionCompanyEntity(model.description, model.headquarters, model.homepage, model.id, model.logo_path, model.name,model.origin_country, model.parent_company?.let { mapFromModel(it) })
    }
}