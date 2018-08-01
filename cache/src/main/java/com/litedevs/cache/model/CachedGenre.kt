package com.litedevs.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.litedevs.cache.db.Constants

data class CachedGenre(
        val id : Int,
        val name : String?
)