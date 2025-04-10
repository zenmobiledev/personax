package com.mobbelldev.personax.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.room.Room
import com.mobbelldev.personax.data.source.local.dao.FavoriteUserDao
import com.mobbelldev.personax.data.source.local.db.AppDatabase
import com.mobbelldev.personax.data.source.local.preference.PreferenceDataStore
import com.mobbelldev.personax.data.source.local.preference.dataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        context.dataStore

    @Provides
    @Singleton
    fun providePreferenceDataStore(dataStore: DataStore<Preferences>): PreferenceDataStore =
        PreferenceDataStore(dataStore = dataStore)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = "personax_db"
        ).build()
    }

    @Provides
    fun provideFavoriteUserDao(database: AppDatabase): FavoriteUserDao {
        return database.favoriteUserDao()
    }
}