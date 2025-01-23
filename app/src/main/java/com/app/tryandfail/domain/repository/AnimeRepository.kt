package com.app.tryandfail.domain.repository

import com.app.tryandfail.domain.models.AnimeItemModel
import com.app.tryandfail.domain.models.ResultState
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
    suspend fun getTopAnimeList(): Flow<ResultState<List<AnimeItemModel>>>
    suspend fun getAnimeDetail(id:Int):  Flow<ResultState<AnimeItemModel>>
}