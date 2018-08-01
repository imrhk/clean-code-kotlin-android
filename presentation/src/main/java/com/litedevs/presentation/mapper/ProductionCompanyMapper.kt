package com.litedevs.presentation.mapper

import com.litedevs.presentation.model.ProductionCompanyView
import model.TProductionCompany
import javax.inject.Inject

class ProductionCompanyMapper @Inject constructor() : Mapper<ProductionCompanyView, TProductionCompany> {
    override fun mapToView(type: TProductionCompany): ProductionCompanyView {
        return ProductionCompanyView(type.description, type.headquarters, type.homepage, type.id, type.logo_path, type.name, type.origin_country,
                type.parent_company?.let { mapToView(it) })
    }
}