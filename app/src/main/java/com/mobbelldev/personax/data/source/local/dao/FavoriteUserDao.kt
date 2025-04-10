package com.mobbelldev.personax.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobbelldev.personax.data.source.local.entity.FavoriteUserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteUser(favoriteUser: FavoriteUserEntity)

    @Delete
    suspend fun deleteFavoriteUser(favoriteUser: FavoriteUserEntity)

    @Query("SELECT * FROM favoriteuserentity")
    fun getAllFavorites(): Flow<List<FavoriteUserEntity>>
}