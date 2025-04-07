package com.mobbelldev.personax.domain.model

import com.google.gson.annotations.SerializedName

data class Coordinates(

	@field:SerializedName("lng")
	val lng: Any? = null,

	@field:SerializedName("lat")
	val lat: Any? = null
)