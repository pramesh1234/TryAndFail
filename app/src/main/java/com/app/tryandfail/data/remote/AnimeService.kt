package com.app.tryandfail.data.remote

import com.app.tryandfail.domain.models.AnimeDetailRes
import com.app.tryandfail.domain.models.AnimeItemModel
import com.app.tryandfail.domain.models.TopAnimeRes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeService {
    @GET("top/anime")
    suspend fun getTopAnimeList():Response<TopAnimeRes>

    @GET("anime/{id}")
    suspend fun getAnimeById(@Path("id") id:Int):Response<AnimeDetailRes>
}