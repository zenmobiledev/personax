package com.mobbelldev.personax.data.source.remote.datasource

import com.mobbelldev.personax.data.source.remote.model.response.UserResponse
import retrofit2.Response

interface PersonaXRemoteDataSource {
    suspend fun getAllUsers(): Response<UserResponse>
}