package com.litedevs.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.litedevs.cache.converter.Converters
import com.litedevs.cache.db.Constants

@Entity(tableName = Constants.MOVIE_LIST_TABLE_NAME)
@TypeConverters(Converters::class)
data class CachedMovieList (
        @ColumnInfo(name = Constants.COLUMN_ID_MOVIES)
        val movies : List<CachedMovie>,

        @PrimaryKey
        @ColumnInfo(name = Constants.COLUMN_ID_TYPE)
        val type : String,

        @ColumnInfo(name = Constants.COLUMN_ID_LAST_CACHED_TIME)
        val lastCacheTime : Long)