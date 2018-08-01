package com.litedevs.data.mapper

import com.litedevs.data.model.LanguageEntity
import model.TLanguage
import javax.inject.Inject

class LanguageMapper @Inject constructor() : EntityMapper<LanguageEntity, TLanguage> {
    override fun mapFromEntity(entity: LanguageEntity): TLanguage {
        return TLanguage(entity.iso_639_1, entity.name)
    }

    override fun entityToMap(map: TLanguage): LanguageEntity {
        return LanguageEntity(map.iso_639_1, map.name)
    }

}