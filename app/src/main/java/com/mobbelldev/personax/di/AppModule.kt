package com.mobbelldev.personax.di

import com.mobbelldev.personax.data.repository.PersonaXRepositoryImpl
import com.mobbelldev.personax.data.source.local.datasource.PersonaXLocalDataSource
import com.mobbelldev.personax.data.source.local.datasource.PersonaXLocalDataSourceImpl
import com.mobbelldev.personax.data.source.local.preference.PreferenceDataStore
import com.mobbelldev.personax.domain.repositories.PersonaXRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRepository(
        localDataSource: PersonaXLocalDataSource,
    ): PersonaXRepository {
        return PersonaXRepositoryImpl(
            personaXLocalDataSource = localDataSource
        )
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        preference: PreferenceDataStore,
    ): PersonaXLocalDataSource {
        return PersonaXLocalDataSourceImpl(
            preferenceDataStore = preference
        )
    }
}