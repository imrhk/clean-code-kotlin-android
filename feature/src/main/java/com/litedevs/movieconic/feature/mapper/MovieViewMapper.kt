package com.litedevs.movieconic.feature.mapper

import com.litedevs.movieconic.feature.model.*
import com.litedevs.presentation.model.*

import javax.inject.Inject

class MovieViewMapper @Inject constructor(
        private val collectionViewMapper: CollectionViewMapper,
        private val genreViewMapper: GenreViewMapper,
        private val productionCompanyViewMapper: ProductionCompanyViewMapper,
        private val productionCountryViewMapper: ProductionCountryViewMapper,
        private val languageViewMapper: LanguageViewMapper,
        private val creditViewMapper: CreditViewMapper,
        private val keywordsViewMapper: KeywordsViewMapper
) : ViewMapper<MovieView, Movie> {

    init {
        collectionViewMapper.movieViewMapper = this
    }

    override fun mapToView(presentation: MovieView): Movie {
        return Movie(presentation.adult,
                presentation.backdrop_path,
                presentation.belongs_to_collection?.let { collectionViewMapper.mapToView(it) },
                presentation.budget,
                presentation.genres?.size?.let { Array(it) { genreViewMapper.mapToView(presentation.genres!![it])} },
                presentation.genre_ids,
                presentation.homepage,
                presentation.id,
                presentation.imdb_id,
                presentation.original_language,
                presentation.original_title,
                presentation.overview,
                presentation.popularity,
                presentation.poster_path,
                presentation.production_companies?.size?.let { Array(it) { productionCompanyViewMapper.mapToView(presentation.production_companies!![it])} },
                presentation.production_countries?.size?.let { Array(it) { productionCountryViewMapper.mapToView(presentation.production_countries!![it])} },
                presentation.release_date,
                presentation.revenue,
                presentation.runtime,
                presentation.spoken_languages?.size?.let { Array(it) { languageViewMapper.mapToView(presentation.spoken_languages!![it])} },
                presentation.status,
                presentation.tagline,
                presentation.original_title,
                presentation.video,
                presentation.vote_average,
                presentation.vote_count,
                presentation.credits?.let { creditViewMapper.mapToView(it) },
                presentation.keywords?.let { keywordsViewMapper.mapToView(it) }
                )
    }
}

