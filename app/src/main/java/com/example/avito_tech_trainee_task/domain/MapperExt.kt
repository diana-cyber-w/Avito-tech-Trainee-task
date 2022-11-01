package com.example.avito_tech_trainee_task.domain

import com.example.avito_tech_trainee_task.domain.model.CurrentWeather
import com.example.avito_tech_trainee_task.domain.model.ForecastData
import com.example.avito_tech_trainee_task.network.dto.CurrentWeatherResponse
import com.example.avito_tech_trainee_task.network.dto.Forecastday

fun CurrentWeatherResponse.toCurrentWeather() =
    CurrentWeather(
        location.name,
        current.last_updated,
        current.temp_c,
        current.condition.icon,
        current.humidity,
        current.condition.text,
        forecast.forecastday.map { forecastday ->
            forecastday.toForecastData()
        }
    )

fun Forecastday.toForecastData() =
    ForecastData(
        date,
        day.maxtemp_c,
        day.avghumidity,
        day.condition.icon
    )

