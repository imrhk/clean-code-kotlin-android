package com.litedevs.data.model

import model.*

class MovieEntity (
        val adult : Boolean?,
        val backdrop_path : String?,
        val belongs_to_collection : CollectionEntity?,
        val budget : Int?,
        val genres : Array<GenreEntity>?,
        val genre_ids : Array<Int>?,
        val homepage : String?,
        val id : Int,
        val imdb_id : String?,
        val original_language : String?,
        val original_title : String?,
        val overview : String?,
        val popularity : Float?,
        val poster_path : String?,
        val production_companies : Array<ProductionCompanyEntity>?,
        val production_countries : Array<ProductionCountryEntity>?,
        val release_date : String?,
        val revenue : Int?,
        val runtime : Int?,
        val spoken_languages : Array<LanguageEntity>?,
        val status : String?,
        val tagline : String?,
        val title : String?,
        val video : Boolean?,
        val vote_average : Float?,
        val vote_count : Int?,
        val credits : CreditEntity?,
        val keywords : KeywordsEntity?
) {
    override fun equals(other: Any?): Boolean {
        if(other is MovieEntity) {
            when {
                id != other.id -> return false
            }
        }
        return true
    }
}