package com.example.unsplashapp.data.repository_impl

import com.example.unsplashapp.data.remote.entity.GetPhotoDetailResult
import com.example.unsplashapp.data.remote.entity.SearchPhotosResult
import com.example.unsplashapp.data.remote.unsplash.UnsplashApi
import com.example.unsplashapp.domain.repository.PhotoRepository
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val api: UnsplashApi,
) : PhotoRepository {

    override suspend fun searchPhotos(query: String) : SearchPhotosResult {
        return api.searchPhotos(query)
    }

    override suspend fun getPhotoDetail(id: String): GetPhotoDetailResult {
        return api.getPhotoDetail(id)
    }
}