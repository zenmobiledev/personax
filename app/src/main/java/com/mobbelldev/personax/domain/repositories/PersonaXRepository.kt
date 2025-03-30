package com.mobbelldev.personax.domain.repositories

import kotlinx.coroutines.flow.Flow

interface PersonaXRepository {
    fun isLogin(): Flow<Boolean>

    suspend fun setLogin(isLogin: Boolean)
}