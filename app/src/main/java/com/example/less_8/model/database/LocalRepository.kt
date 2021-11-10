package com.example.less_8.model.database

import com.example.less_8.model.Film

interface LocalRepository {
    fun getAllHistory(): List<Film>
    fun saveEntity(film: Film)
}