package com.litedevs.remote.mapper

import com.litedevs.data.model.LanguageEntity
import com.litedevs.remote.model.LanguageModel
import javax.inject.Inject

class LanguageModelMapper @Inject constructor() : ModelMapper<LanguageModel, LanguageEntity> {
    override fun mapFromModel(model: LanguageModel): LanguageEntity {
        return LanguageEntity(model.iso_639_1, model.name)
    }
}