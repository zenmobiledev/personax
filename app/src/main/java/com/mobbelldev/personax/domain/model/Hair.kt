package com.mobbelldev.personax.domain.model

import com.google.gson.annotations.SerializedName

data class Hair(

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)