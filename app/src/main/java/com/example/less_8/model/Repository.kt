package com.example.less_8.model

interface Repository {
    fun getFilmFromServer(): List<Film>
    fun getFilmFromLocalStorage(): List<Film>
}