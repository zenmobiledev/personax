package com.mobbelldev.personax.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(
    val country: String? = null,
    val address: String? = null,
    val city: String? = null,
    val postalCode: String? = null,
    val coordinates: Coordinates? = null,
    val stateCode: String? = null,
    val state: String? = null,
) : Parcelable