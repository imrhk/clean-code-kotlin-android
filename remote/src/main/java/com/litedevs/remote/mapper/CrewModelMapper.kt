package com.litedevs.remote.mapper

import com.litedevs.data.model.CrewEntity
import com.litedevs.remote.model.CrewModel
import javax.inject.Inject

class CrewModelMapper @Inject constructor() : ModelMapper<CrewModel, CrewEntity> {
    override fun mapFromModel(model: CrewModel): CrewEntity {
        return CrewEntity(model.credit_id, model.department, model.gender, model.id, model.job, model.name, model.profile_path)
    }
}