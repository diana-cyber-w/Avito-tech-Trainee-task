package com.example.avito_tech_trainee_task.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASE_API_KEY = "175b9249e71845ecbc8134058223110"
    private const val BASE_URL = "https://api.weatherapi.com/v1/"

    private var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private fun getClient(url: String = BASE_URL) = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getWeatherApi(): WeatherApi = getClient().create(WeatherApi::class.java)
}