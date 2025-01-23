package com.app.tryandfail.data.repositoryImpl

import android.util.Log
import com.app.tryandfail.common.ApiResponse
import com.app.tryandfail.common.NetworkUtils
import com.app.tryandfail.data.remote.AnimeService
import com.app.tryandfail.domain.models.AnimeItemModel
import com.app.tryandfail.domain.models.ResultState
import com.app.tryandfail.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(private val animeService: AnimeService) : AnimeRepository {
    override suspend fun getTopAnimeList(): Flow<ResultState<List<AnimeItemModel>>> = flow {
        try {

            val response = NetworkUtils.process {
                animeService.getTopAnimeList()
            }
            when (response) {
                is ApiResponse.Success -> {
                    emit(ResultState.Success(response.data.data))
                }

                is ApiResponse.Failure -> {
                    emit(ResultState.Error(message = response.message))
                }
            }
        }catch (e:Exception){
            emit(ResultState.Error(message = e.message?:"Something Went Wrong"))
        }
    }

    override suspend fun getAnimeDetail(id: Int):  Flow<ResultState<AnimeItemModel>> = flow{
        try {

            val response = NetworkUtils.process {
                animeService.getAnimeById(id)
            }
            when (response) {
                is ApiResponse.Success -> {
                    Log.d("TAG", "getTopAnimeList: ${response}")
                    emit(ResultState.Success(response.data.data))
                }

                is ApiResponse.Failure -> {
                    emit(ResultState.Error(message = response.message))
                }
            }
        }catch (e:Exception){
            emit(ResultState.Error(message = e.message?:"Something Went Wrong"))
        }
    }

}


