package com.mobbelldev.personax.data.source.remote.model.response

import com.google.gson.annotations.SerializedName
import com.mobbelldev.personax.data.source.remote.model.UsersItemDTO

data class UserResponse(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("skip")
	val skip: Int? = null,

	@field:SerializedName("users")
	val users: List<UsersItemDTO?>? = null
)