package com.example.unsplashapp.presentation.search_photos

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unsplashapp.common.NetworkResponse
import com.example.unsplashapp.domain.use_case.SearchPhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchPhotosViewModel @Inject constructor(
    private val searchPhotosUseCase: SearchPhotoUseCase
) : ViewModel() {
    //viewModelの中でのみ使用し、viewModelの中でのみ状態を変更する
    private val _state = mutableStateOf(SearchPhotosState())

    //viewから参照されるstate
    val state: State<SearchPhotosState> = _state

    init {
        searchPhotos("cat")
    }

    fun searchPhotos(query: String) {
        searchPhotosUseCase(query).onEach { result ->
            when (result) {
                is NetworkResponse.Success -> {
                    _state.value = SearchPhotosState(
                        isLoading = false,
                        photos = result.data,
                    )
                }

                is NetworkResponse.Error -> {
                    _state.value = SearchPhotosState(error = result.error)
                }

                is NetworkResponse.Loading -> {
                    _state.value = SearchPhotosState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}