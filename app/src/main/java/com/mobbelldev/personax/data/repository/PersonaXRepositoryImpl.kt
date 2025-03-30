package com.mobbelldev.personax.data.repository

import com.mobbelldev.personax.data.source.local.datasource.PersonaXLocalDataSource
import com.mobbelldev.personax.domain.repositories.PersonaXRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonaXRepositoryImpl @Inject constructor(
    private val personaXLocalDataSource: PersonaXLocalDataSource,
) : PersonaXRepository {
    override fun isLogin(): Flow<Boolean> = personaXLocalDataSource.isLogin()
    override suspend fun setLogin(isLogin: Boolean) =
        personaXLocalDataSource.setLogin(isLogin = isLogin)
}