package com.litedevs.cache.model

import java.util.*

data class CachedKeyword (
        val id : Int,
        val name : String?
)

data class CachedKeywords(
        val keywords : List<CachedKeyword>?

)