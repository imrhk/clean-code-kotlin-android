package com.litedevs.movieconic.feature.model

data class Movie (
        val adult : Boolean?,
        val backdrop_path : String?,
        val belongs_to_collection : Collection?,
        val budget : Int?,
        val genres : Array<Genre>?,
        val genre_ids : Array<Int>?,
        val homepage : String?,
        val id : Int,
        val imdb_id : String?,
        val original_language : String?,
        val original_title : String?,
        val overview : String?,
        val popularity : Float?,
        val poster_path : String?,
        val production_companies : Array<ProductionCompany>?,
        val production_countries : Array<ProductionCountry>?,
        val release_date : String?,
        val revenue : Int?,
        val runtime : Int?,
        val spoken_languages : Array<Language>?,
        val status : String?,
        val tagline : String?,
        val title : String?,
        val video : Boolean?,
        val vote_average : Float?,
        val vote_count : Int?,
        val credits : Credit?,
        val keywords : Keywords?
        )