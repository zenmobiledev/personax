package com.mobbelldev.personax.domain.usecases

import com.mobbelldev.personax.domain.model.FavoriteUser
import com.mobbelldev.personax.domain.repositories.PersonaXRepository
import javax.inject.Inject

class InsertFavoriteUserUseCase @Inject constructor(private val repository: PersonaXRepository) {
    suspend operator fun invoke(favoriteUser: FavoriteUser) = repository.insertFavoriteUser(
        favoriteUser = favoriteUser
    )
}