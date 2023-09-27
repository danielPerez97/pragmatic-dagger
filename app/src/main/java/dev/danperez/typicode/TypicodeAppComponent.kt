package dev.danperez.typicode

import dagger.Component
import dev.danperez.typicode.di.TypicodeModule
import javax.inject.Singleton

@Singleton
@Component(modules = [TypicodeModule::class])
interface TypicodeAppComponent
{
    fun inject(mainActivity: MainActivity)
}