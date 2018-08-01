package com.litedevs.presentation.mapper

import com.litedevs.presentation.model.CastView
import model.TCast
import javax.inject.Inject

class CastMapper @Inject constructor() : Mapper<CastView, TCast> {
    override fun mapToView(type: TCast): CastView {
        return CastView(type.cast_id, type.character, type.credit_id, type.gender, type.cast_id, type.name, type.order, type.profile_path)
    }
}