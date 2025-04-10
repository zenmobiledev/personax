package com.mobbelldev.personax.domain.repositories

import com.mobbelldev.personax.domain.model.FavoriteUser
import com.mobbelldev.personax.domain.model.User
import com.mobbelldev.personax.utils.Response
import kotlinx.coroutines.flow.Flow

interface PersonaXRepository {
    fun isLogin(): Flow<Boolean>

    suspend fun setLogin(isLogin: Boolean)

    suspend fun getAllUsers(): Flow<Response<User>>

    fun getFavoriteUsers(): Flow<List<FavoriteUser>>

    suspend fun insertFavoriteUser(favoriteUser: FavoriteUser)

    suspend fun deleteFavoriteUser(favoriteUser: FavoriteUser)
}