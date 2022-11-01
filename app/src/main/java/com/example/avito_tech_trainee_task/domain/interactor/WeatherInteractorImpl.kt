package com.example.avito_tech_trainee_task.domain.interactor

import com.example.avito_tech_trainee_task.domain.model.CurrentWeather
import com.example.avito_tech_trainee_task.domain.repository.NetworkRepository
import com.example.avito_tech_trainee_task.domain.toCurrentWeather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherInteractorImpl @Inject constructor(
    private val networkRepository: NetworkRepository
) : WeatherInteractor {
    override suspend fun getCurrentWeather(city: String): CurrentWeather? {
        return withContext(Dispatchers.IO) {
            networkRepository.getCurrentWeather(city)?.toCurrentWeather()
        }
    }
}