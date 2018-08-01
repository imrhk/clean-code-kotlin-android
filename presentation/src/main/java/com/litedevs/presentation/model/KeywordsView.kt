package com.litedevs.presentation.model

data class KeywordView (
        val id : Int,
        val name : String?
)

data class KeywordsView (
    val keywords : Array<KeywordView>?
)