package com.example.less_8.viewmodel

import com.example.less_8.model.Film
import com.example.less_8.model.FilmDTO


sealed class AppState {
    data class Success(val filmData: List<Film>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}