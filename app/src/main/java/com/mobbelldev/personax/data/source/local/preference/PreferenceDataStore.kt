package com.mobbelldev.personax.data.source.local.preference

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PreferenceDataStore.PREFERENCE_NAME)

class PreferenceDataStore(private val dataStore: DataStore<Preferences>) {

    val isLogin: Flow<Boolean> = dataStore.data
        .map { it[PreferenceParameter.IS_LOGIN] ?: false }
        .catch { emit(false) }

    suspend fun setLogin(isLogin: Boolean) {
        dataStore.edit {
            it[PreferenceParameter.IS_LOGIN] = isLogin
        }
    }

    companion object {
        const val PREFERENCE_NAME = "personax_pref"
    }
}