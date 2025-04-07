package com.mobbelldev.personax.domain.model

import com.google.gson.annotations.SerializedName

data class UsersItem(

	@field:SerializedName("lastName")
	val lastName: String? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("university")
	val university: String? = null,

	@field:SerializedName("maidenName")
	val maidenName: String? = null,

	@field:SerializedName("ein")
	val ein: String? = null,

	@field:SerializedName("ssn")
	val ssn: String? = null,

	@field:SerializedName("bloodGroup")
	val bloodGroup: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("hair")
	val hair: Hair? = null,

	@field:SerializedName("bank")
	val bank: Bank? = null,

	@field:SerializedName("eyeColor")
	val eyeColor: String? = null,

	@field:SerializedName("company")
	val company: Company? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("height")
	val height: Any? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("address")
	val address: Address? = null,

	@field:SerializedName("ip")
	val ip: String? = null,

	@field:SerializedName("weight")
	val weight: Any? = null,

	@field:SerializedName("userAgent")
	val userAgent: String? = null,

	@field:SerializedName("birthDate")
	val birthDate: String? = null,

	@field:SerializedName("crypto")
	val crypto: Crypto? = null,

	@field:SerializedName("firstName")
	val firstName: String? = null,

	@field:SerializedName("macAddress")
	val macAddress: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("age")
	val age: Int? = null,

	@field:SerializedName("username")
	val username: String? = null
)