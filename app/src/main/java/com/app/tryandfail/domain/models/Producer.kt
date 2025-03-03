package com.app.tryandfail.domain.models


import com.google.gson.annotations.SerializedName

data class Producer(
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)