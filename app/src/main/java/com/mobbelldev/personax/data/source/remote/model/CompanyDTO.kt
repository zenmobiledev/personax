package com.mobbelldev.personax.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class CompanyDTO(

    @field:SerializedName("address")
	val addressDTO: AddressDTO? = null,

    @field:SerializedName("name")
	val name: String? = null,

    @field:SerializedName("department")
	val department: String? = null,

    @field:SerializedName("title")
	val title: String? = null
)