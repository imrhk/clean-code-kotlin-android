package com.litedevs.movieconic.feature.model

data class Collection (
        val id : Int,
        val name : String?,
        val overview : String?,
        val poster_path : String?,
        val backdrop_path : String?,
        val parts : Array<Movie>?
)