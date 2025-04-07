package com.mobbelldev.personax.data.source.remote.api

import com.mobbelldev.personax.data.source.remote.model.response.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface PersonaXService {
    @GET("users")
    suspend fun getAllUsers(): Response<UserResponse>
}