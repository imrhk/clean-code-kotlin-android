package com.litedevs.presentation.mapper

import com.litedevs.presentation.model.ProductionCountryView
import model.TProductionCountry
import javax.inject.Inject

class ProductionCountryMapper @Inject constructor() : Mapper<ProductionCountryView, TProductionCountry> {
    override fun mapToView(type: TProductionCountry): ProductionCountryView {
        return ProductionCountryView(type.iso_3166_1, type.name)
    }
}