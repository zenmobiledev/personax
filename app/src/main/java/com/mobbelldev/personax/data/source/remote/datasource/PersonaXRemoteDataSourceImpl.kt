package com.mobbelldev.personax.data.source.remote.datasource

import com.mobbelldev.personax.data.source.remote.api.PersonaXService
import com.mobbelldev.personax.data.source.remote.model.response.UserResponse
import retrofit2.Response
import javax.inject.Inject

class PersonaXRemoteDataSourceImpl @Inject constructor(private val personaXService: PersonaXService) :
    PersonaXRemoteDataSource {
    override suspend fun getAllUsers(): Response<UserResponse> {
        return try {
            personaXService.getAllUsers()
        } catch (e: Exception) {
            throw Exception(e.message.toString())
        }
    }
}