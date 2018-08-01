package com.litedevs.movieconic.feature.mapper

import com.litedevs.movieconic.feature.model.ProductionCompany
import com.litedevs.presentation.model.ProductionCompanyView
import javax.inject.Inject

class ProductionCompanyViewMapper @Inject constructor() : ViewMapper<ProductionCompanyView, ProductionCompany> {
    override fun mapToView(presentation: ProductionCompanyView): ProductionCompany {
        return ProductionCompany(presentation.description, presentation.headquarters, presentation.homepage, presentation.id, presentation.logo_path, presentation.name, presentation.origin_country, presentation.parent_company?.let { mapToView(it)})
    }
}