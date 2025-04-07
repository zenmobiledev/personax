package com.mobbelldev.personax.domain.model

data class User(
    val total: Int? = null,
    val limit: Int? = null,
    val skip: Int? = null,
    val users: List<UsersItem?>? = null,
)