package com.example.avito_tech_trainee_task.network

import com.example.avito_tech_trainee_task.network.dto.CurrentWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast.json")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("lang") language: String,
        @Query("aqi") airQuality: String,
        @Query("days") days: Int,
        @Query("key") key: String = RetrofitClient.BASE_API_KEY,
    ): Response<CurrentWeatherResponse>
}