package com.mobbelldev.personax.di

import com.mobbelldev.personax.BuildConfig
import com.mobbelldev.personax.data.source.remote.api.PersonaXService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {
        val interceptor = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor().setLevel(
                level = HttpLoggingInterceptor.Level.BODY
            )
        } else {
            HttpLoggingInterceptor().setLevel(
                level = HttpLoggingInterceptor.Level.NONE
            )
        }

        return OkHttpClient.Builder().apply {
            addInterceptor(interceptor = interceptor)
        }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl("https://dummyjson.com/")
            client(okHttpClient)
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): PersonaXService {
        return retrofit.create(PersonaXService::class.java)
    }
}