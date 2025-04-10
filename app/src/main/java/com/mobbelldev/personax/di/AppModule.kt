package com.mobbelldev.personax.di

import com.mobbelldev.personax.data.mapper.FavoriteUserMapper
import com.mobbelldev.personax.data.mapper.UserResponseMapper
import com.mobbelldev.personax.data.repository.PersonaXRepositoryImpl
import com.mobbelldev.personax.data.source.local.dao.FavoriteUserDao
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
        userResponseMapper: UserResponseMapper,
        favoriteUserMapper: FavoriteUserMapper,
    ): PersonaXRepository {
        return PersonaXRepositoryImpl(
            personaXLocalDataSource = localDataSource,
            personaXRemoteDataSource = remoteDataSource,
            userResponseMapper = userResponseMapper,
            favoriteUserMapper = favoriteUserMapper,
        )
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        preference: PreferenceDataStore,
        favoriteUserDao: FavoriteUserDao,
    ): PersonaXLocalDataSource {
        return PersonaXLocalDataSourceImpl(
            preferenceDataStore = preference,
            favoriteUserDao = favoriteUserDao
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