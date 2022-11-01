package com.example.avito_tech_trainee_task.domain.repository

import com.example.avito_tech_trainee_task.network.dto.CurrentWeatherResponse

interface NetworkRepository {
    suspend fun getCurrentWeather(city: String): CurrentWeatherResponse?
}