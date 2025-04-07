package com.mobbelldev.personax.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class CoordinatesDTO(

	@field:SerializedName("lng")
	val lng: Any? = null,

	@field:SerializedName("lat")
	val lat: Any? = null
)