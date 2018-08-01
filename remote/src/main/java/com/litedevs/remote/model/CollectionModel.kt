package com.litedevs.remote.model

data class CollectionModel (
        val id : Int,
        val name : String?,
        val overview : String?,
        val poster_path : String?,
        val backdrop_path : String?,
        val parts : Array<MovieModel>?
)