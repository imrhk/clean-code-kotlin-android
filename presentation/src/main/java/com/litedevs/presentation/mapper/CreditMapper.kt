package com.litedevs.presentation.mapper

import com.litedevs.presentation.model.CreditView
import model.TCredit
import javax.inject.Inject

class CreditMapper @Inject constructor(private val castMapper: CastMapper, private val crewMapper: CrewMapper) : Mapper<CreditView, TCredit> {
    override fun mapToView(type: TCredit): CreditView {
        return CreditView(
                type.cast?.size?.let { Array(it) { it -> castMapper.mapToView(type.cast!![it]) } },
                type.crew?.size?.let { Array(it) { it -> crewMapper.mapToView(type.crew!![it]) } }
        )
    }
}