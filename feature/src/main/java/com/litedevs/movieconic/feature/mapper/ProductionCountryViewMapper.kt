package com.litedevs.movieconic.feature.mapper

import com.litedevs.movieconic.feature.model.ProductionCountry
import com.litedevs.presentation.model.ProductionCountryView
import javax.inject.Inject

class ProductionCountryViewMapper @Inject constructor() : ViewMapper<ProductionCountryView, ProductionCountry> {
    override fun mapToView(presentation: ProductionCountryView): ProductionCountry {
        return ProductionCountry(presentation.iso_3166_1, presentation.name)
    }
}