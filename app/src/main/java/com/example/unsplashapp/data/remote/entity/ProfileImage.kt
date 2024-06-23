package com.example.unsplashapp.data.remote.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProfileImage(
    val large: String?,
    val medium: String?,
    val small: String?
)