package com.example.avito_tech_trainee_task

import android.app.Application

class DaggerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger()
    }

    private fun initDagger(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .bindContext(this@DaggerApplication)
            .build()
    }

    companion object {
        var appComponent: ApplicationComponent? = null
    }
}