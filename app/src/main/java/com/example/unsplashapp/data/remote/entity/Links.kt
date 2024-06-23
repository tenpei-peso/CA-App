package com.example.unsplashapp.data.remote.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(
    val download: String?,
    val html: String?,
    val self: String?
)