package com.app.tryandfail.presentation.screen.detailScreen

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.annotation.OptIn
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.dash.DashMediaSource
import com.app.tryandfail.domain.models.AnimeItemModel
import com.app.tryandfail.domain.models.ResultState
import com.app.tryandfail.domain.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(val repository: AnimeRepository) : ViewModel() {

    private val _animeDetail = MutableLiveData<AnimeItemModel>()
    var animeDetail = _animeDetail

    private val _isLoading = MutableStateFlow<Boolean>(false)
    var isLoading = _isLoading.asStateFlow()

     fun getTopAnimeList(id:Int) {
        viewModelScope.launch {
            repository.getAnimeDetail(id).collectLatest {
                when (it) {
                    is ResultState.Success -> {
                        _animeDetail.postValue(it.data?:return@collectLatest)
                        _isLoading.emit(false)
                    }

                    is ResultState.Error -> {
                        _isLoading.emit(false)
                    }

                    is ResultState.Loading -> {
                        _isLoading.emit(true)
                    }

                }
            }
        }
    }

}