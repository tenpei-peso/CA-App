package com.example.unsplashapp.presentation.root

sealed class ScreenRoot(
    val route: String
) {
    object SearchPhotosScreen : ScreenRoot("search_photos_screen")
    object PhotoDetailScreen : ScreenRoot("photo_detail_screen")

}