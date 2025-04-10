package com.mobbelldev.personax.data.mapper

import com.mobbelldev.personax.data.source.local.entity.FavoriteUserEntity
import com.mobbelldev.personax.domain.model.FavoriteUser
import javax.inject.Inject

class FavoriteUserMapper @Inject constructor() {
    fun mapDomainToEntity(domain: FavoriteUser): FavoriteUserEntity {
        return FavoriteUserEntity(
            id = domain.id,
            username = domain.username,
            email = domain.email,
            image = domain.image,
            isFavorite = domain.isFavorite
        )
    }

    fun mapEntityToDomain(entity: FavoriteUserEntity): FavoriteUser {
        return FavoriteUser(
            id = entity.id,
            username = entity.username.toString(),
            email = entity.email.toString(),
            image = entity.image.toString(),
            isFavorite = entity.isFavorite
        )
    }
}