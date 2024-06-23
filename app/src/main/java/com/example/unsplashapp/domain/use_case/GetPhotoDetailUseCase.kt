package com.example.unsplashapp.domain.use_case

import com.example.unsplashapp.common.NetworkResponse
import com.example.unsplashapp.data.remote.entity.toPhotoDetail
import com.example.unsplashapp.domain.model.PhotoDetail
import com.example.unsplashapp.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPhotoDetailUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    operator fun invoke(id: String) : Flow<NetworkResponse<PhotoDetail>> = flow{
        try {
            emit(NetworkResponse.Loading<PhotoDetail>())
            val result = repository.getPhotoDetail(id).toPhotoDetail()
            emit(NetworkResponse.Success<PhotoDetail>(result))
        } catch (e: Exception) {
            emit(NetworkResponse.Error(e.message.toString()))
        }
    }
}