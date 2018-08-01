package com.litedevs.movieconic.feature.model

data class Keyword (
        val id : Int,
        val name : String?
)

data class Keywords (
    val keywords : Array<Keyword>?
)