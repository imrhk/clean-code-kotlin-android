package com.litedevs.remote.model

data class ProductionCompanyModel (
        val description : String?,
        val headquarters : String?,
        val homepage : String?,
        val id : Int,
        val logo_path : String?,
        val name : String?,
        val origin_country : String?,
        val parent_company : ProductionCompanyModel?
)
