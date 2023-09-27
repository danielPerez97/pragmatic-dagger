package dev.danperez.typicode

import android.app.Application

class TypicodeApplication: Application()
{
    lateinit var typicodeAppComponent: TypicodeAppComponent

    override fun onCreate() {
        super.onCreate()
        typicodeAppComponent = DaggerTypicodeAppComponent.create()
    }
}