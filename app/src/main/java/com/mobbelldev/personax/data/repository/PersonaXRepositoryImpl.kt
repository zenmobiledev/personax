package com.mobbelldev.personax.data.repository

import com.mobbelldev.personax.data.mapper.FavoriteUserMapper
import com.mobbelldev.personax.data.mapper.UserResponseMapper
import com.mobbelldev.personax.data.source.local.datasource.PersonaXLocalDataSource
import com.mobbelldev.personax.data.source.remote.datasource.PersonaXRemoteDataSource
import com.mobbelldev.personax.domain.model.FavoriteUser
import com.mobbelldev.personax.domain.model.User
import com.mobbelldev.personax.domain.repositories.PersonaXRepository
import com.mobbelldev.personax.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PersonaXRepositoryImpl @Inject constructor(
    private val personaXLocalDataSource: PersonaXLocalDataSource,
    private val personaXRemoteDataSource: PersonaXRemoteDataSource,
    private val userResponseMapper: UserResponseMapper,
    private val favoriteUserMapper: FavoriteUserMapper,
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
                    userResponseMapper.map(
                        response = response
                    )
                }
                emit(Response.Success(userResponse))

            } catch (e: Exception) {
                emit(Response.Error(e.message.toString()))
            }
        }
    }

    override fun getFavoriteUsers(): Flow<List<FavoriteUser>> {
        return personaXLocalDataSource.getFavoriteUsers().map { list ->
            list.map {
                favoriteUserMapper.mapEntityToDomain(entity = it)
            }
        }
    }

    override suspend fun insertFavoriteUser(favoriteUser: FavoriteUser) {
        personaXLocalDataSource.insertFavoriteUser(
            favoriteUserEntity = favoriteUserMapper.mapDomainToEntity(
                domain = favoriteUser
            )
        )
    }

    override suspend fun deleteFavoriteUser(favoriteUser: FavoriteUser) {
        personaXLocalDataSource.deleteFavoriteUser(
            favoriteUserEntity = favoriteUserMapper.mapDomainToEntity(
                domain = favoriteUser
            )
        )
    }
}