package com.mobbelldev.personax.data.mapper

import com.mobbelldev.personax.data.source.remote.model.response.UserResponse
import com.mobbelldev.personax.domain.model.User
import javax.inject.Inject

class UserResponseMapper @Inject constructor(private val usersItemMapper: UsersItemMapper) {
    fun map(response: UserResponse): User {
        return User(
//            total = ,
//            limit = ,
//            skip = ,
            users = response.users?.map { usersItemMapper.map(usersItemDTO = it) }
        )
    }
}