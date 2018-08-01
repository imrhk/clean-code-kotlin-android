package com.litedevs.remote.model

import com.google.gson.annotations.SerializedName

data class MoviesResponseModel(@SerializedName("results", alternate = arrayOf("items")) val items : List<MovieModel>,
                               val page : Int?,
                               val total_results : Int?,
                               val total_pages : Int?
                               )