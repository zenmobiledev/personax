package com.mobbelldev.personax.di

import com.mobbelldev.personax.data.mapper.Mapper
import com.mobbelldev.personax.data.repository.PersonaXRepositoryImpl
import com.mobbelldev.personax.data.source.local.datasource.PersonaXLocalDataSource
import com.mobbelldev.personax.data.source.local.datasource.PersonaXLocalDataSourceImpl
import com.mobbelldev.personax.data.source.local.preference.PreferenceDataStore
import com.mobbelldev.personax.data.source.remote.api.PersonaXService
import com.mobbelldev.personax.data.source.remote.datasource.PersonaXRemoteDataSource
import com.mobbelldev.personax.data.source.remote.datasource.PersonaXRemoteDataSourceImpl
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
        remoteDataSource: PersonaXRemoteDataSource,
        mapper: Mapper,
    ): PersonaXRepository {
        return PersonaXRepositoryImpl(
            personaXLocalDataSource = localDataSource,
            personaXRemoteDataSource = remoteDataSource,
            mapper = mapper
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

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        personaXService: PersonaXService,
    ): PersonaXRemoteDataSource {
        return PersonaXRemoteDataSourceImpl(
            personaXService = personaXService
        )
    }
}