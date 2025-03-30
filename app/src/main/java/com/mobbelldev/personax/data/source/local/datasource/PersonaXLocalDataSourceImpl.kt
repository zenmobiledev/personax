package com.mobbelldev.personax.data.source.local.datasource

import com.mobbelldev.personax.data.source.local.preference.PreferenceDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonaXLocalDataSourceImpl @Inject constructor(
    private val preferenceDataStore: PreferenceDataStore,
) : PersonaXLocalDataSource {
    override fun isLogin(): Flow<Boolean> = preferenceDataStore.isLogin

    override suspend fun setLogin(isLogin: Boolean) =
        preferenceDataStore.setLogin(isLogin = isLogin)
}