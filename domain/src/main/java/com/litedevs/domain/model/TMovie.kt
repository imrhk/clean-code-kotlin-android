package model

data class TMovie (
        val adult : Boolean?,
        val backdrop_path : String?,
        val belongs_to_collection : TCollection?,
        val budget : Int?,
        val genres : Array<TGenre>?,
        val genre_ids : Array<Int>?,
        val homepage : String?,
        val id : Int,
        val imdb_id : String?,
        val original_language : String?,
        val original_title : String?,
        val overview : String?,
        val popularity : Float?,
        val poster_path : String?,
        val production_companies : Array<TProductionCompany>?,
        val production_countries : Array<TProductionCountry>?,
        val release_date : String?,
        val revenue : Int?,
        val runtime : Int?,
        val spoken_languages : Array<TLanguage>?,
        val status : String?,
        val tagline : String?,
        val title : String?,
        val video : Boolean?,
        val vote_average : Float?,
        val vote_count : Int?,
        val credits : TCredit?,
        val keywords : TKeywords?
        )