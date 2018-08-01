package com.litedevs.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.litedevs.cache.db.Constants

data class CachedCrew (
        val credit_id : String,
        val department : String?,
        val gender : Int?,
        val id : Int?,
        val job : String?,
        val name : String?,
        val profile_path : String?
)