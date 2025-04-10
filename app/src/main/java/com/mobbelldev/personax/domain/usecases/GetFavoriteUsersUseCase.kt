package com.mobbelldev.personax.domain.usecases

import com.mobbelldev.personax.domain.model.FavoriteUser
import com.mobbelldev.personax.domain.repositories.PersonaXRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteUsersUseCase @Inject constructor(private val repository: PersonaXRepository) {
    operator fun invoke(): Flow<List<FavoriteUser>> {
        return repository.getFavoriteUsers()
    }
}