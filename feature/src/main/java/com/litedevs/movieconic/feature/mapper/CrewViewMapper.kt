package com.litedevs.movieconic.feature.mapper

import com.litedevs.movieconic.feature.model.Crew
import com.litedevs.presentation.model.CrewView
import javax.inject.Inject

class CrewViewMapper @Inject constructor() : ViewMapper<CrewView, Crew> {
    override fun mapToView(presentation: CrewView): Crew {
        return Crew(presentation.credit_id, presentation.department, presentation.gender, presentation.id, presentation.job, presentation.name, presentation.profile_path)
    }
}