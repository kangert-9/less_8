package com.example.less_8.model.database

import com.example.less_8.model.Film

class LocalRepositoryImpl(private val localDataSource: HistoryDao) :
    LocalRepository {

    override fun getAllHistory(): List<Film> {
        return convertHistoryEntityToFilm(localDataSource.all())
    }

    override fun saveEntity(film: Film) {
        localDataSource.insert(convertFilmToEntity(film))
    }

    fun convertHistoryEntityToFilm(entityList: List<HistoryEntity>):
            List<Film> {
        return entityList.map {
            Film(0, "null", 0.0, "null", 2000, false)
        }
    }

    fun convertFilmToEntity(film: Film): HistoryEntity {
        return HistoryEntity(0, film.name.toString())
    }
}