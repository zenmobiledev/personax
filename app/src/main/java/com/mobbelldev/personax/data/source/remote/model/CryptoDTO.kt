package com.mobbelldev.personax.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class CryptoDTO(

	@field:SerializedName("wallet")
	val wallet: String? = null,

	@field:SerializedName("coin")
	val coin: String? = null,

	@field:SerializedName("network")
	val network: String? = null
)