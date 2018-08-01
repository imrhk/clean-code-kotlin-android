package com.litedevs.cache.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.litedevs.cache.db.Constants
import java.util.*

data class CachedCollection(
        val id : Int,
        val name : String?,
        val overview : String?,
        val poster_path : String?,
        val backdrop_path : String?,
        val parts : List<CachedMovie>?
)