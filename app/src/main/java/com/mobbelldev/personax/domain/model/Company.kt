package com.mobbelldev.personax.domain.model

import com.google.gson.annotations.SerializedName

data class Company(

	@field:SerializedName("address")
	val address: Address? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("department")
	val department: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)