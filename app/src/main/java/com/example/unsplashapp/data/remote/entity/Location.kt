package com.example.unsplashapp.data.remote.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Location(
    val city: String?,
    val country: String?,
    val position: Position?
)