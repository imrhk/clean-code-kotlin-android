package com.litedevs.presentation.mapper

import com.litedevs.presentation.model.*
import model.*
import javax.inject.Inject

class MovieViewMapper @Inject constructor(
        private val collectionMapper: CollectionMapper,
        private val genreMapper: GenreMapper,
        private val productionCompanyMapper: ProductionCompanyMapper,
        private val productionCountryMapper: ProductionCountryMapper,
        private val languageMapper: LanguageMapper,
        private val creditMapper: CreditMapper,
        private val keywordsMapper: KeywordsMapper) : Mapper<MovieView, TMovie> {

    init {
        collectionMapper.movieViewMapper = this
    }

    override fun mapToView(type: TMovie): MovieView {
        return MovieView(type.adult,
                type.backdrop_path,
                type.belongs_to_collection?.let { collectionMapper.mapToView(it) },
                type.budget,
                type.genres?.size?.let { Array(it) { it -> genreMapper.mapToView(type.genres!![it])} },
                type.genre_ids,
                type.homepage,
                type.id,
                type.imdb_id,
                type.original_language,
                type.original_title,
                type.overview,
                type.popularity,
                type.poster_path,
                type.production_companies?.size?.let { Array(it) { it -> productionCompanyMapper.mapToView(type.production_companies!![it])} },
                type.production_countries?.size?.let { Array(it) { it -> productionCountryMapper.mapToView(type.production_countries!![it])} },
                type.release_date,
                type.revenue,
                type.runtime,
                type.spoken_languages?.size?.let { Array(it) { it -> languageMapper.mapToView(type.spoken_languages!![it])} },
                type.status,
                type.tagline,
                type.original_title,
                type.video,
                type.vote_average,
                type.vote_count,
                type.credits?.let { creditMapper.mapToView(it) },
                type.keywords?.let { keywordsMapper.mapToView(it) })
    }
}