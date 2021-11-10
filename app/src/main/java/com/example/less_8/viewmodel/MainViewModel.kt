package com.example.less_8.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.less_8.model.Repository
import com.example.less_8.model.RepositoryImpl
import java.lang.Thread.sleep
import kotlin.random.Random

class MainViewModel : ViewModel() {
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val repositoryImpl: Repository = RepositoryImpl()
    fun getLiveData() = liveDataToObserve

    fun getFilm() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            if(Random.nextBoolean()) {
                liveDataToObserve.postValue(AppState.Success(repositoryImpl.getFilmFromLocalStorage()))
            } else {
                liveDataToObserve.postValue(AppState.Error(Exception("нет интернета")))
            }
        }.start()
    }
}