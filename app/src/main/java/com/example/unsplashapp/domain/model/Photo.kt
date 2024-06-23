package com.example.unsplashapp.domain.model

// アプリで使用するために、DTOから必要な情報だけを抽出したデータクラス
data class Photo(
    val photoId: String,
    val description: String?,
    val likes: Int?,
    val imageUrl: String,
    val photographer: String?
)
