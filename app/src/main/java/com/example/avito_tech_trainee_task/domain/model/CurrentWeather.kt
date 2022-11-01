package com.example.avito_tech_trainee_task.domain.model

data class CurrentWeather(
    val locationName: String,
    val lastUpdated: String,
    val tempC: Double,
    val conditionIcon: String,
    val humidity: Int,
    val conditionText: String,
    val forecast: List<ForecastData>
)

data class ForecastData(
    val date: String,
    val maxTempC: Double,
    val humidity: Double,
    val conditionIcon: String
)
