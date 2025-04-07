package com.mobbelldev.personax.domain.model

import com.google.gson.annotations.SerializedName

data class Address(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("postalCode")
	val postalCode: String? = null,

	@field:SerializedName("coordinates")
	val coordinates: Coordinates? = null,

	@field:SerializedName("stateCode")
	val stateCode: String? = null,

	@field:SerializedName("state")
	val state: String? = null
)