package com.mobbelldev.personax.domain.model

data class FavoriteUser(
    val id: Int,
    val username: String,
    val email: String,
    val image: String,
    val isFavorite: Boolean = false,
)
