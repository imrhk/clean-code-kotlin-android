package com.litedevs.cache.mapper

import com.litedevs.cache.model.CachedMovie
import com.litedevs.data.model.CreditEntity
import com.litedevs.data.model.KeywordsEntity
import com.litedevs.data.model.MovieEntity
import javax.inject.Inject

class CachedMovieMapper @Inject constructor(
        private val collectionMapper: CachedCollectionMapper,
        private val genreMapper: CachedGenreMapper,
        private val languageMapper: CachedLanguageMapper,
        private val cachedProductionCompanyMapper: CachedProductionCompanyMapper,
        private val cachedProductionCountryMapper: CachedProductionCountryMapper,
        private val castMapper: CachedCastMapper,
        private val crewMapper: CachedCrewMapper,
        private val keywordMapper: CachedKeywordMapper) : CacheMapper<CachedMovie, MovieEntity> {

    init {
        collectionMapper.cachedMovieMapper = this
    }

    override fun mapFromCached(type: CachedMovie): MovieEntity {
        return MovieEntity(type.adult,
                type.backdrop_path,
                type.belongs_to_collection?.let { collectionMapper.mapFromCached(it) },
                type.budget,
                type.genres?.let { Array(type.genres.size) {genreMapper.mapFromCached(type.genres[it]) } },
                type.genre_ids?.let { Array(type.genre_ids.size) {it} },
                type.homepage,
                type.id,
                type.imdb_id,
                type.original_language,
                type.original_title,
                type.overview,
                type.popularity,
                type.poster_path,
                type.production_companies?.let { Array(type.production_companies.size) {cachedProductionCompanyMapper.mapFromCached(type.production_companies[it]) } },
                type.production_countries?.let { Array(type.production_countries.size) {cachedProductionCountryMapper.mapFromCached(type.production_countries[it]) } },
                type.release_date,
                type.revenue,
                type.runtime,
                type.spoken_languages?.let { Array(type.spoken_languages.size) {languageMapper.mapFromCached(type.spoken_languages[it]) } },
                type.status,
                type.tagline,
                type.original_title,
                type.video,
                type.vote_average,
                type.vote_count,
                CreditEntity(type.cast?.let { Array(type.cast.size) { castMapper.mapFromCached(type.cast[it]) } },
                        type.crew?.let { Array(type.crew.size) { crewMapper.mapFromCached(type.crew[it]) } }) ,
                 KeywordsEntity(type.keyword?.let { Array(type.keyword.size) {keywordMapper.mapFromCached(type.keyword[it])} })
        )
    }

    override fun mapToCached(type: MovieEntity): CachedMovie {
        return CachedMovie(type.adult,
                type.backdrop_path,
                type.belongs_to_collection?.let { collectionMapper.mapToCached(it) },
                type.budget,
                type.genres?.let { type.genres!!.asList().map{genreMapper.mapToCached(it)} },
                type.genre_ids?.let { type.genre_ids!!.asList()},
                type.homepage,
                type.id,
                type.imdb_id,
                type.original_language,
                type.original_title,
                type.overview,
                type.popularity,
                type.poster_path,
                type.production_companies?.let { type.production_companies!!.asList().map{cachedProductionCompanyMapper.mapToCached(it)} },
                type.production_countries?.let { type.production_countries!!.asList().map{cachedProductionCountryMapper.mapToCached(it)} },
                type.release_date,
                type.revenue,
                type.runtime,
                type.spoken_languages?.let { type.spoken_languages!!.asList().map{languageMapper.mapToCached(it)} },
                type.status,
                type.tagline,
                type.original_title,
                type.video,
                type.vote_average,
                type.vote_count,
                type.credits?.cast?.let{ type.credits!!.cast!!.toList().map { castMapper.mapToCached(it) } },
                type.credits?.crew?.let{ type.credits!!.crew!!.toList().map { crewMapper.mapToCached(it) } },
                type.keywords?.keywords?.let { type.keywords?.keywords!!.toList().map { keywordMapper.mapToCached(it) } })
    }
}