package com.litedevs.movieconic.feature.mapper

import com.litedevs.movieconic.feature.model.Credit
import com.litedevs.presentation.model.CreditView
import javax.inject.Inject

class CreditViewMapper @Inject constructor(private val castViewMapper: CastViewMapper, private val crewViewMapper: CrewViewMapper) : ViewMapper<CreditView, Credit> {
    override fun mapToView(presentation: CreditView): Credit {
        return Credit(
                presentation.cast?.let { Array(presentation.cast!!.size) { castViewMapper.mapToView(presentation.cast!![it]) } },
                presentation.crew?.let { Array(presentation.crew!!.size) { crewViewMapper.mapToView(presentation.crew!![it]) } })
    }
}