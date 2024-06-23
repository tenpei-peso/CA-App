package com.example.unsplashapp.domain.repository

import com.example.unsplashapp.data.remote.entity.GetPhotoDetailResult
import com.example.unsplashapp.data.remote.entity.SearchPhotosResult

interface PhotoRepository {

    //写真検索一覧を取得する
    suspend fun searchPhotos(query: String): SearchPhotosResult

    //写真詳細を取得する
    suspend fun getPhotoDetail(id: String): GetPhotoDetailResult
}