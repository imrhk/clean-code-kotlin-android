package com.litedevs.cache.db

object Constants {
    const val DB_NAME = "movie.db"
    const val DB_VERSION = 1

    const val MOVIE_TABLE_NAME = "movie"
    const val MOVIE_LIST_TABLE_NAME = "movie_list"
    const val COLLECTION_TABLE_NAME = "collection"
    const val CREDITS_TABLE_NAME = "credits"
    const val CAST_TABLE_NAME = "cast"
    const val CREW_TABLE_NAME = "crew"
    const val GENRE_TABLE_NAME = "genre"
    const val KEYWORD_TABLE_NAME = "keywords"
    const val LANGUAGE_TABLE_NAME = "language"
    const val COMPANY_TABLE_NAME = "production_company"
    const val COUNTRY_TABLE_NAME = "country"

    const val COLUMN_ID_MOVIES = "movies"
    const val COLUMN_ID_TYPE = "type"
    const val COLUMN_ID_LAST_CACHED_TIME = "last_cache_time"
}