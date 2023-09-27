package dev.danperez.typicode.di

import dagger.Module
import dagger.Provides
import dev.danperez.typicode.TypicodeService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class TypicodeModule
{
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient
    {
        return OkHttpClient()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit
    {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .build()
    }

    @Provides
    fun provideTypicodeService(retrofit: Retrofit): TypicodeService
    {
        return retrofit.create(TypicodeService::class.java)
    }
}