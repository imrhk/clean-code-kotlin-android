package com.litedevs.cache.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.litedevs.cache.dao.MovieListDao
import com.litedevs.cache.model.*
import javax.inject.Inject

@Database(entities = arrayOf(CachedMovieList::class),
        version = Constants.DB_VERSION,
        exportSchema = false)
abstract class MovieDatabase @Inject constructor() : RoomDatabase() {

    abstract fun cachedMovieListDao() : MovieListDao

    companion object {
        private var INSTANCE : MovieDatabase? = null
        private val lock = Any()

        fun getInstance(context : Context) : MovieDatabase {
            if(INSTANCE == null) {
                synchronized(lock) {
                    if(INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                MovieDatabase::class.java, Constants.DB_NAME)
                                .build()
                        return INSTANCE as MovieDatabase
                    }
                }
            }
            return INSTANCE as MovieDatabase
        }
    }
}
