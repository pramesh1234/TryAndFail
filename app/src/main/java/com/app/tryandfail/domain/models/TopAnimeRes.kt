package com.app.tryandfail.domain.models

import com.google.gson.annotations.SerializedName

data class TopAnimeRes(@SerializedName("data") val data:List<AnimeItemModel>)