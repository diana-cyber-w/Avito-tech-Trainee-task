package com.example.avito_tech_trainee_task.network.dto

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("location")
    val location: Location,
    @SerializedName("current")
    val current: Current,
    @SerializedName("forecast")
    val forecast: Forecast
)

data class Location(
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)

data class Current(
    @SerializedName("last_updated")
    val last_updated: String,
    @SerializedName("temp_c")
    val temp_c: Double,
    @SerializedName("condition")
    val condition: Condition,
    @SerializedName("wind_kph")
    val wind_kph: Double,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("feelslike_c")
    val feelslike_c: Double
)

data class Condition(
    @SerializedName("text")
    val text: String,
    @SerializedName("icon")
    val icon: String
)

data class Forecast(
    @SerializedName("forecastday")
    val forecastday: List<Forecastday>
)

data class Forecastday(
    @SerializedName("date")
    val date: String,
    @SerializedName("day")
    val day: Day
)

data class Day(
    @SerializedName("maxtemp_c")
    val maxtemp_c: Double,
    @SerializedName("avghumidity")
    val avghumidity: Double,
    @SerializedName("condition")
    val condition: Condition,
    @SerializedName("maxwind_kph")
    val maxwind_kph: Double
)
