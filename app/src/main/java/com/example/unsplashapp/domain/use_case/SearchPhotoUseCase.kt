package com.example.unsplashapp.domain.use_case

import com.example.unsplashapp.common.NetworkResponse
import com.example.unsplashapp.data.remote.entity.toPhotos
import com.example.unsplashapp.domain.model.Photo
import com.example.unsplashapp.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchPhotoUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    operator fun invoke(query: String) : Flow<NetworkResponse<List<Photo>>> = flow {
        try {
            emit(NetworkResponse.Loading<List<Photo>>())
            val result = repository.searchPhotos(query).toPhotos()
            emit(NetworkResponse.Success<List<Photo>>(result))
        } catch (e: Exception) {
            emit(NetworkResponse.Error(e.message.toString()))
        }
    }

}