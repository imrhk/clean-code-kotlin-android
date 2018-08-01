package com.litedevs.data.mapper

interface EntityMapper<E, D> {
    fun mapFromEntity(entity : E) : D
    fun entityToMap(map : D) : E
}