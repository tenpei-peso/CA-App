package com.example.unsplashapp.data.remote.entity


import com.example.unsplashapp.domain.model.PhotoDetail
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetPhotoDetailResult(
    @Json(name = "blur_hash")
    val blurHash: String?,
    val color: String?,
    @Json(name = "created_at")
    val createdAt: String?,
    @Json(name = "current_user_collections")
    val currentUserCollections: List<CurrentUserCollection>?,
    val description: String?,
    val downloads: Int?,
    val exif: Exif?,
    val height: Int?,
    val id: String?,
    @Json(name = "liked_by_user")
    val likedByUser: Boolean?,
    val likes: Int?,
    val links: LinksXX?,
    val location: Location?,
    @Json(name = "public_domain")
    val publicDomain: Boolean?,
    val tags: List<Tag>?,
    @Json(name = "updated_at")
    val updatedAt: String?,
    val urls: UrlsX?,
    val user: UserX?,
    val width: Int?
)

fun GetPhotoDetailResult.toPhotoDetail(): PhotoDetail {
    return PhotoDetail(
        description = description ?: "",
        likes = likes ?: 0,
        imageUrl = urls?.raw ?: "",
        photographer = user?.username ?: "",
        camera = exif?.name ?: "",
        location = "${location?.city}, ${location?.country}" ?: "",
        downloads = downloads ?: 0,
    )
}