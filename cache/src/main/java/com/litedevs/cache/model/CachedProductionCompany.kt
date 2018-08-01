package com.litedevs.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.litedevs.cache.db.Constants

data class CachedProductionCompany(
        val description : String?,
        val headquarters : String?,
        val homepage : String?,
        val id : Int,
        val logo_path : String?,
        val name : String?,
        val origin_country : String?,
        val parent_company : CachedProductionCompany?
)