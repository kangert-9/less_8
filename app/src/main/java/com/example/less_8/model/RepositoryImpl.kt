package com.example.less_8.model

import com.example.less_8.model.Repository

class RepositoryImpl : Repository
{
    override fun getFilmFromServer() = getFilms()
    override fun getFilmFromLocalStorage() = getFilms()
}