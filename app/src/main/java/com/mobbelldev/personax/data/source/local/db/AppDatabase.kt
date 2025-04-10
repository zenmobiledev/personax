package com.mobbelldev.personax.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mobbelldev.personax.data.source.local.dao.FavoriteUserDao
import com.mobbelldev.personax.data.source.local.entity.FavoriteUserEntity

@Database(
    entities = [FavoriteUserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteUserDao(): FavoriteUserDao
}