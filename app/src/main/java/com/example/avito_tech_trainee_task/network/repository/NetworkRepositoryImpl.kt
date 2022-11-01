package com.example.avito_tech_trainee_task.network.repository

import com.example.avito_tech_trainee_task.domain.repository.NetworkRepository
import com.example.avito_tech_trainee_task.network.WeatherApi
import com.example.avito_tech_trainee_task.network.dto.CurrentWeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(private val weatherApi: WeatherApi) :
    NetworkRepository {
    override suspend fun getCurrentWeather(city: String): CurrentWeatherResponse? {
        return withContext(Dispatchers.IO) {
            if (weatherApi.getCurrentWeather(
                    city,
                    LANGUAGE,
                    AIR_QUALITY,
                    DAYS_NUMBER
                ).isSuccessful
            ) {
                return@withContext weatherApi.getCurrentWeather(
                    city,
                    LANGUAGE,
                    AIR_QUALITY,
                    DAYS_NUMBER
                ).body()
            } else {
                return@withContext null
            }
        }
    }

    companion object {
        private const val LANGUAGE = "ru"
        private const val AIR_QUALITY = "no"
        private const val DAYS_NUMBER = 7
    }
}