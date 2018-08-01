package com.litedevs.data.model

import model.TKeyword

data class KeywordEntity (
    val id : Int,
    val name : String?
)

data class KeywordsEntity (
    val keywords : Array<KeywordEntity>?
)