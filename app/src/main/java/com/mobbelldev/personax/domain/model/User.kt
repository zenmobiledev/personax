package com.mobbelldev.personax.domain.model

import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("skip")
	val skip: Int? = null,

	@field:SerializedName("users")
	val users: List<UsersItem?>? = null
)