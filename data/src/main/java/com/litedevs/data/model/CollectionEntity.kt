package com.litedevs.data.model

data class CollectionEntity (
        val id: Int,
        val name: String?,
        val overview: String?,
        val poster_path: String?,
        val backdrop_path: String?,
        val parts: Array<MovieEntity>?
)