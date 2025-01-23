package com.app.tryandfail.domain.models


import com.google.gson.annotations.SerializedName

data class Jpg(
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("large_image_url")
    val largeImageUrl: String,
    @SerializedName("small_image_url")
    val smallImageUrl: String
)