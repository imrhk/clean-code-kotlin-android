package com.litedevs.cache.dao

import androidx.room.*
import com.litedevs.cache.converter.Converters
import com.litedevs.cache.db.Constants.COLUMN_ID_LAST_CACHED_TIME
import com.litedevs.cache.db.Constants.COLUMN_ID_MOVIES
import com.litedevs.cache.db.Constants.COLUMN_ID_TYPE
import com.litedevs.cache.db.Constants.MOVIE_LIST_TABLE_NAME
import com.litedevs.cache.model.CachedMovie
import com.litedevs.cache.model.CachedMovieList
import io.reactivex.Flowable

@Dao
abstract class MovieListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun setMovies(movieList: CachedMovieList)

    @Query("SELECT * FROM $MOVIE_LIST_TABLE_NAME WHERE $COLUMN_ID_TYPE = :type" )
    abstract fun getMovieList(type: String) : Flowable<List<CachedMovieList>>

    @Query("DELETE FROM $MOVIE_LIST_TABLE_NAME where $COLUMN_ID_TYPE = :type")
    abstract fun clearMovieList(type: String)

    @Query("UPDATE $MOVIE_LIST_TABLE_NAME SET $COLUMN_ID_LAST_CACHED_TIME = :time where $COLUMN_ID_TYPE = :type")
    abstract fun setCacheTime(time : Long, type: String)
}