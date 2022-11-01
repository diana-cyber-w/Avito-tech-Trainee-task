package com.example.avito_tech_trainee_task.network.di

import com.example.avito_tech_trainee_task.domain.repository.NetworkRepository
import com.example.avito_tech_trainee_task.network.RetrofitClient
import com.example.avito_tech_trainee_task.network.WeatherApi
import com.example.avito_tech_trainee_task.network.repository.NetworkRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun providesWeatherApi(): WeatherApi = RetrofitClient.getWeatherApi()

    @Provides
    fun providesNetworkRepositoryImpl(
        weatherApi: WeatherApi
    ): NetworkRepository = NetworkRepositoryImpl(weatherApi = weatherApi)
}