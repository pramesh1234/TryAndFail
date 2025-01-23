package com.app.tryandfail.presentation.screen.homeScreen

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
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
class HomeViewModel @Inject constructor(private val animeRepository: AnimeRepository, private val savedStateHandle: SavedStateHandle) : ViewModel() {

    init {
        getTopAnimeList()
    }

    private val _topAnimeList = MutableSharedFlow<List<AnimeItemModel>>()
    var topAnimeList = _topAnimeList.asSharedFlow()

    private val _isLoading = MutableStateFlow<Boolean>(false)
    var isLoading = _isLoading.asStateFlow()

    private fun getTopAnimeList() {
        viewModelScope.launch {
            animeRepository.getTopAnimeList().collectLatest {
                when (it) {
                    is ResultState.Success -> {
                        _topAnimeList.emit(it.data?: emptyList())
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