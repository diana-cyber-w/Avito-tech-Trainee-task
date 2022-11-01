package com.example.avito_tech_trainee_task.domain.di

import com.example.avito_tech_trainee_task.domain.interactor.WeatherInteractor
import com.example.avito_tech_trainee_task.domain.interactor.WeatherInteractorImpl
import com.example.avito_tech_trainee_task.domain.repository.NetworkRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun providesWeatherInteractor(
        networkRepository: NetworkRepository
    ): WeatherInteractor =
        WeatherInteractorImpl(networkRepository)
}