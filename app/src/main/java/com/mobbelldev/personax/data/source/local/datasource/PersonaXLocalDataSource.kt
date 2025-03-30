package com.mobbelldev.personax.data.source.local.datasource

import kotlinx.coroutines.flow.Flow

interface PersonaXLocalDataSource {
    fun isLogin(): Flow<Boolean>

    suspend fun setLogin(isLogin: Boolean)
}