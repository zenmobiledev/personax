package com.mobbelldev.personax.data.repository

import com.mobbelldev.personax.data.mapper.Mapper
import com.mobbelldev.personax.data.source.local.datasource.PersonaXLocalDataSource
import com.mobbelldev.personax.data.source.remote.datasource.PersonaXRemoteDataSource
import com.mobbelldev.personax.domain.model.User
import com.mobbelldev.personax.domain.repositories.PersonaXRepository
import com.mobbelldev.personax.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PersonaXRepositoryImpl @Inject constructor(
    private val personaXLocalDataSource: PersonaXLocalDataSource,
    private val personaXRemoteDataSource: PersonaXRemoteDataSource,
    private val mapper: Mapper,
) : PersonaXRepository {
    override fun isLogin(): Flow<Boolean> = personaXLocalDataSource.isLogin()
    override suspend fun setLogin(isLogin: Boolean) =
        personaXLocalDataSource.setLogin(isLogin = isLogin)

    override suspend fun getAllUsers(): Flow<Response<User>> {
        return flow {
            emit(Response.Loading)
            val response = personaXRemoteDataSource.getAllUsers()
            try {
                val userResponse = response.body()?.let { response ->
                    mapper.mapResponseToDomain(response = response)
                }
                emit(Response.Success(userResponse))

            } catch (e: Exception) {
                emit(Response.Error(e.message.toString()))
            }
        }
    }
}