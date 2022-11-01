package com.example.avito_tech_trainee_task.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.avito_tech_trainee_task.domain.interactor.WeatherInteractor
import com.example.avito_tech_trainee_task.domain.model.CurrentWeather
import kotlinx.coroutines.launch
import javax.inject.Inject

class SharedViewModel @Inject constructor(
    private val weatherInteractor: WeatherInteractor
) : ViewModel() {

    val currentWeather: LiveData<CurrentWeather> get() = _currentWeather
    private val _currentWeather = MutableLiveData<CurrentWeather>()

    fun loadCurrentWeather(city: String) {
        viewModelScope.launch {
            _currentWeather.value = weatherInteractor.getCurrentWeather(city)
        }
    }
}