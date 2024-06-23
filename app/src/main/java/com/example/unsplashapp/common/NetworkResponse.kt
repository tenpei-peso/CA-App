package com.example.unsplashapp.common

//sealed class NetworkResponse<T>(
//    val data: T? = null,
//    val error: String? = null
//) {
//    class Success<T>(data: T) : NetworkResponse<T>(data = data)
//    class Error<T>(error: String) : NetworkResponse<T>(error = error)
//    class Loading<T> : NetworkResponse<T>()
//}

sealed class NetworkResponse<T> {
    class Success<T>(val data: T) : NetworkResponse<T>()
    class Error<T>(val error: String) : NetworkResponse<T>()
    class Loading<T> : NetworkResponse<T>()
}


