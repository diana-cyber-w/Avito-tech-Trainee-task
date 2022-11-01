package com.example.avito_tech_trainee_task

import android.content.Context
import com.example.avito_tech_trainee_task.domain.di.DomainModule
import com.example.avito_tech_trainee_task.network.di.NetworkModule
import com.example.avito_tech_trainee_task.presentation.di.PresentationModule
import com.example.avito_tech_trainee_task.presentation.fragments.CurrentWeather
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DomainModule::class,
        NetworkModule::class,
        PresentationModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindContext(context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun inject(currentWeather: CurrentWeather)
}