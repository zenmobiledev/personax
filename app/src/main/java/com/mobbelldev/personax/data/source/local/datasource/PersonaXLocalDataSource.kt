package com.mobbelldev.personax.data.source.local.datasource

import com.mobbelldev.personax.data.source.local.entity.FavoriteUserEntity
import kotlinx.coroutines.flow.Flow

interface PersonaXLocalDataSource {
    fun isLogin(): Flow<Boolean>

    suspend fun setLogin(isLogin: Boolean)

    suspend fun insertFavoriteUser(favoriteUserEntity: FavoriteUserEntity)

    suspend fun deleteFavoriteUser(favoriteUserEntity: FavoriteUserEntity)

    fun getFavoriteUsers(): Flow<List<FavoriteUserEntity>>
}