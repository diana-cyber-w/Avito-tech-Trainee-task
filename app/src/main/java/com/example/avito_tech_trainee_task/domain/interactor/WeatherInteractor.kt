package com.example.avito_tech_trainee_task.domain.interactor

import com.example.avito_tech_trainee_task.domain.model.CurrentWeather

interface WeatherInteractor {
    suspend fun getCurrentWeather(city: String): CurrentWeather?
}