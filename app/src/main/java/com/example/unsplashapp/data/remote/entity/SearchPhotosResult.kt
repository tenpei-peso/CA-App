package com.example.unsplashapp.data.remote.entity


import com.example.unsplashapp.domain.model.Photo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchPhotosResult(
    val results: List<Result>?,
    val total: Int?,
    @Json(name = "total_pages")
    val totalPages: Int?
)

fun SearchPhotosResult.toPhotos(): List<Photo> {
    return results?.map {
        Photo(
            photoId = it.id ?: "",
            description = it.description ?: "",
            likes = it.likes ?: 0,
            imageUrl = it.urls?.raw ?: "",
            photographer = it.user?.username ?: "",
        )
    } ?: emptyList()
}
