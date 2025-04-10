package com.mobbelldev.personax.data.source.local.datasource

import com.mobbelldev.personax.data.source.local.dao.FavoriteUserDao
import com.mobbelldev.personax.data.source.local.entity.FavoriteUserEntity
import com.mobbelldev.personax.data.source.local.preference.PreferenceDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PersonaXLocalDataSourceImpl @Inject constructor(
    private val preferenceDataStore: PreferenceDataStore,
    private val favoriteUserDao: FavoriteUserDao,
) : PersonaXLocalDataSource {
    override fun isLogin(): Flow<Boolean> = preferenceDataStore.isLogin

    override suspend fun setLogin(isLogin: Boolean) =
        preferenceDataStore.setLogin(isLogin = isLogin)

    override suspend fun insertFavoriteUser(favoriteUserEntity: FavoriteUserEntity) {
        favoriteUserDao.insertFavoriteUser(
            favoriteUser = favoriteUserEntity
        )
    }

    override suspend fun deleteFavoriteUser(favoriteUserEntity: FavoriteUserEntity) {
        favoriteUserDao.deleteFavoriteUser(
            favoriteUser = favoriteUserEntity
        )
    }

    override fun getFavoriteUsers(): Flow<List<FavoriteUserEntity>> {
        return favoriteUserDao.getAllFavorites().map { list ->
            list.map {
                FavoriteUserEntity(
                    id = it.id,
                    username = it.username,
                    email = it.email,
                    image = it.image,
                    isFavorite = it.isFavorite
                )
            }
        }
    }
}