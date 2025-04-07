package com.mobbelldev.personax.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class BankDTO(

	@field:SerializedName("iban")
	val iban: String? = null,

	@field:SerializedName("cardExpire")
	val cardExpire: String? = null,

	@field:SerializedName("cardType")
	val cardType: String? = null,

	@field:SerializedName("currency")
	val currency: String? = null,

	@field:SerializedName("cardNumber")
	val cardNumber: String? = null
)