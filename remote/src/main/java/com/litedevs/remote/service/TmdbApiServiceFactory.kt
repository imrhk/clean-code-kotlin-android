package com.litedevs.remote.service

import Movieconic.BuildConfig;
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class TmdbApiServiceFactory {
    companion object {
        fun makeTmdbApiService(isDebug: Boolean): TmdbApiService {
            val okHttpClient = makeOkHttpClient(makeLoggingInterceptor(isDebug))
            okHttpClient.dispatcher().maxRequests = 1
            return makeTmdbApiService(okHttpClient, Gson())

        }

        private fun makeTmdbApiService(okHttpClient: OkHttpClient, gson: Gson): TmdbApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl("https://api.themoviedb.org/3/")
                    .client(okHttpClient)
                    .build()
            return retrofit.create(TmdbApiService::class.java)
        }

        private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
            return OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .addInterceptor { chain ->
                        val request = chain.request()
                        val originalHttpUrl = request.url()

                        val urlWithApiKey = originalHttpUrl.newBuilder()
                                .addQueryParameter("api_key", BuildConfig.TmdbApiKey)
                                .build()

                        chain.proceed(request.newBuilder().method(request.method(),request.body()).url(urlWithApiKey).build())
                    }
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build()
        }

        private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
            val logging = HttpLoggingInterceptor()
            logging.level = if (isDebug) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
            return logging
        }
    }
}
