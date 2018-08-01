package com.litedevs.presentation.model

data class CollectionView (
        val id : Int,
        val name : String?,
        val overview : String?,
        val poster_path : String?,
        val backdrop_path : String?,
        val parts : Array<MovieView>?
)