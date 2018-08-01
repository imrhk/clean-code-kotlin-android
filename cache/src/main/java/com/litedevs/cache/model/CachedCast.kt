package com.litedevs.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.litedevs.cache.db.Constants

data class CachedCast(
        val cast_id : Int,
        val character : String?,
        val credit_id : String?,
        val gender : String?,
        val id : Int?,
        val name : String?,
        val order : Int?,
        val profile_path : String?
)