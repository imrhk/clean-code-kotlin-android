package com.litedevs.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.litedevs.cache.db.Constants

data class CachedLanguage (
        val iso_639_1 : String,
        val name : String?
)