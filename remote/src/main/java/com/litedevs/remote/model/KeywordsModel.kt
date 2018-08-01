package com.litedevs.remote.model

data class KeywordModel (
        val id : Int,
        val name : String?
)

data class KeywordsModel (
    val keywords : Array<KeywordModel>?
)