package com.litedevs.remote.service

import com.litedevs.remote.model.MoviesResponseModel
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApiService {
    @GET("movie/now_playing")
    fun getNowPlayingMovies(@Query("page") page : Int,
                            @Query("language") language : String = "en-US",
                            @Query("region") region : String? = null)
    : Flowable<MoviesResponseModel>

    @GET("movie/popular")
    fun getPopularMovies(@Query("page") page : Int,
                         @Query("language") language : String = "en-US",
                         @Query("region") region : String? = null)
            : Flowable<MoviesResponseModel>

    @GET("movie/upcoming")
    fun getComingSoonMovies(@Query("page") page : Int,
                            @Query("language") language : String = "en-Us",
                            @Query("region") region : String? = null)
            : Flowable<MoviesResponseModel>

    @GET("list/{list_id}")
    fun getList(@Path("list_id") listId : Int, @Query("language") language : String = "en-US") : Flowable<MoviesResponseModel>

}