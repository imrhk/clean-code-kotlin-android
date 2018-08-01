package com.litedevs.remote.mapper

import com.litedevs.data.model.MovieEntity
import com.litedevs.remote.model.MovieModel
import javax.inject.Inject

class MovieResponseModelMapper @Inject constructor(
        private val collectionModelMapper: CollectionModelMapper,
        private val genreModelMapper : GenreModelMapper,
        private val productionCompanyModelMapper: ProductionCompanyModelMapper,
        private val productionCountryModelMapper: ProductionCountryModelMapper,
        private val languageModelMapper: LanguageModelMapper,
        private val creditModelMapper : CreditModelMapper,
        private val keywordsModelMapper: KeywordsModelMapper
) : ModelMapper<MovieModel, MovieEntity> {

    init {
        collectionModelMapper.movieResponseModelMapper = this
    }

    override fun mapFromModel(model: MovieModel): MovieEntity {
        return MovieEntity(model.adult,
                model.backdrop_path,
                model.belongs_to_collection?.let { collectionModelMapper.mapFromModel(it)},
                model.budget,
                model.genreModels?.size?.let { Array(it) { genreModelMapper.mapFromModel(model.genreModels[it])} },
                model.genre_ids,
                model.homepage,
                model.id,
                model.imdb_id,
                model.original_language,
                model.original_title,
                model.overview,
                model.popularity,
                model.poster_path,
                model.production_companies?.size?.let { Array(it) { productionCompanyModelMapper.mapFromModel(model.production_companies[it])} },
                model.production_countries?.size?.let { Array(it) { productionCountryModelMapper.mapFromModel(model.production_countries[it])} },
                model.release_date,
                model.revenue,
                model.runtime,
                model.spoken_languages?.size?.let { Array(it) {languageModelMapper.mapFromModel(model.spoken_languages[it])} },
                model.status,
                model.tagline,
                model.original_title,
                model.video,
                model.vote_average,
                model.vote_count,
                model.credits?.let { creditModelMapper.mapFromModel(it) },
                model.keywords?.let { keywordsModelMapper.mapFromModel(it) })
    }
}