package com.mobbelldev.personax.domain.model

import com.google.gson.annotations.SerializedName

data class Crypto(

	@field:SerializedName("wallet")
	val wallet: String? = null,

	@field:SerializedName("coin")
	val coin: String? = null,

	@field:SerializedName("network")
	val network: String? = null
)