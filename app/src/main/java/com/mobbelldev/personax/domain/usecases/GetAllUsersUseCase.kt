package com.mobbelldev.personax.domain.usecases

import com.mobbelldev.personax.data.source.remote.api.PersonaXService
import com.mobbelldev.personax.domain.repositories.PersonaXRepository
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(private val repository: PersonaXRepository) {
    suspend operator fun invoke() = repository.getAllUsers()
}