package com.litedevs.movieconic.feature.mapper

import com.litedevs.movieconic.feature.model.Cast
import com.litedevs.presentation.model.CastView
import javax.inject.Inject

class CastViewMapper @Inject constructor() : ViewMapper<CastView, Cast> {
    override fun mapToView(presentation: CastView): Cast {
        return Cast(presentation.cast_id, presentation.character, presentation.credit_id, presentation.gender, presentation.id, presentation.name, presentation.order, presentation.profile_path)
    }
}