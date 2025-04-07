package com.mobbelldev.personax.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class HairDTO(

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)