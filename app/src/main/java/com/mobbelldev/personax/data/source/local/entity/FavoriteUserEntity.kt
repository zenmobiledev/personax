package com.mobbelldev.personax.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteUserEntity(
    @PrimaryKey val id: Int,
    val username: String?,
    val email: String?,
    val image: String?,
    val isFavorite: Boolean = false,
)