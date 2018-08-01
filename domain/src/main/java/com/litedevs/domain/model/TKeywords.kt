package model

data class TKeyword (
        val id : Int,
        val name : String?
)

data class TKeywords (
    val keywords : Array<TKeyword>?
)