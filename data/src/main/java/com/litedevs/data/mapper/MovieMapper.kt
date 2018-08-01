package com.litedevs.data.mapper

import com.litedevs.data.model.MovieEntity
import model.TMovie
import javax.inject.Inject

class MovieMapper @Inject constructor(
        private val collectionMapper: CollectionMapper,
        private val creditMapper: CreditMapper,
        private val genreMapper: GenreMapper,
        private val languageMapper: LanguageMapper,
        private val keywordsMapper: KeywordsMapper,
        private val productionCompanyMapper: ProductionCompanyMapper,
        private val productionCountryMapper: ProductionCountryMapper
)  : EntityMapper<MovieEntity, TMovie> {

    init {
        collectionMapper.movieMapper = this
    }

    override fun mapFromEntity(entity: MovieEntity): TMovie {
        return TMovie(entity.adult, 
                entity.backdrop_path, 
                entity.belongs_to_collection?.let { collectionMapper.mapFromEntity(it) },
                entity.budget,
                entity.genres?.let { Array(entity.genres.size) { genreMapper.mapFromEntity(entity.genres[it])} },
                entity.genre_ids,
                entity.homepage,
                entity.id, 
                entity.imdb_id, 
                entity.original_language, 
                entity.original_title, 
                entity.overview, 
                entity.popularity, 
                entity.poster_path, 
                entity.production_companies?.let { Array(entity.production_companies.size) { productionCompanyMapper.mapFromEntity(entity.production_companies[it])} },
                entity.production_countries?.let {Array(entity.production_countries.size) { productionCountryMapper.mapFromEntity(entity.production_countries[it])} },
                entity.release_date,
                entity.revenue, 
                entity.runtime,
                entity.spoken_languages?.let { Array(entity.spoken_languages.size) { languageMapper.mapFromEntity(entity.spoken_languages[it])} },
                entity.status, 
                entity.tagline, 
                entity.original_title, 
                entity.video, 
                entity.vote_average, 
                entity.vote_count,
                entity.credits?.let { creditMapper.mapFromEntity(it)},
                entity.keywords?.let { keywordsMapper.mapFromEntity(it) }
                )
    }

    override fun entityToMap(map: TMovie): MovieEntity {
        return MovieEntity(map.adult,
                map.backdrop_path,
                map.belongs_to_collection?.let { collectionMapper.entityToMap(it) },
                map.budget,
                map.genres?.let { Array(map.genres!!.size) { genreMapper.entityToMap(map.genres!![it])} },
                map.genre_ids,
                map.homepage,
                map.id,
                map.imdb_id,
                map.original_language,
                map.original_title,
                map.overview,
                map.popularity,
                map.poster_path,
                map.production_companies?.let { Array(map.production_companies!!.size) { productionCompanyMapper.entityToMap(map.production_companies!![it])} },
                map.production_countries?.let { Array(map.production_countries!!.size) { productionCountryMapper.entityToMap(map.production_countries!![it])} },
                map.release_date,
                map.revenue,
                map.runtime,
                map.spoken_languages?.let { Array(map.spoken_languages!!.size) { languageMapper.entityToMap(map.spoken_languages!![it])} },
                map.status,
                map.tagline,
                map.original_title,
                map.video,
                map.vote_average,
                map.vote_count,
                map.credits?.let { creditMapper.entityToMap(it)},
                map.keywords?.let { keywordsMapper.entityToMap(it) })
    }

}