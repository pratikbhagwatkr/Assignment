package com.example.assignment

import android.app.Application
import com.example.assignment.di.AppComponent
import com.example.assignment.di.DaggerAppComponent

class MainApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent=DaggerAppComponent.builder().build()

    }
}