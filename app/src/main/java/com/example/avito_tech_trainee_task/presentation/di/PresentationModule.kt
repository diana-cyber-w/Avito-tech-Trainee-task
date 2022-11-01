package com.example.avito_tech_trainee_task.presentation.di

import com.example.avito_tech_trainee_task.domain.interactor.WeatherInteractor
import com.example.avito_tech_trainee_task.presentation.SharedViewModel
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun providesSharedViewModel(
        interactor: WeatherInteractor
    ): SharedViewModel =
        SharedViewModel(weatherInteractor = interactor)
}