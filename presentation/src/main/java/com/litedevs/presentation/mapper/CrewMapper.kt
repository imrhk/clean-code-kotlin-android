package com.litedevs.presentation.mapper

import com.litedevs.presentation.model.CrewView
import model.TCrew
import javax.inject.Inject

class CrewMapper @Inject constructor() : Mapper<CrewView, TCrew> {
    override fun mapToView(type: TCrew): CrewView {
        return CrewView(type.credit_id, type.department, type.gender, type.id, type.job, type.name, type.profile_path)
    }
}