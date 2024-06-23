package com.example.unsplashapp.presentation.search_photos

import com.example.unsplashapp.domain.model.Photo

data class SearchPhotosState(
    val isLoading: Boolean = false,
    val photos: List<Photo> = emptyList(),
    val error: String? = null
)
