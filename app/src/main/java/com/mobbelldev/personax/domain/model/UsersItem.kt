package com.mobbelldev.personax.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class UsersItem(
    val fullName: String? = null,
    val lastName: String? = null,
    val role: String? = null,
    val gender: String? = null,
    val university: String? = null,
    val maidenName: String? = null,
    val ein: String? = null,
    val ssn: String? = null,
    val bloodGroup: String? = null,
    val password: String? = null,
    val hair: Hair? = null,
    val bank: Bank? = null,
    val eyeColor: String? = null,
    val company: Company? = null,
    val id: Int? = null,
    val email: String? = null,
    val height: @RawValue Any? = null,
    val image: String? = null,
    val address: Address? = null,
    val ip: String? = null,
    val weight: @RawValue Any? = null,
    val userAgent: String? = null,
    val birthDate: String? = null,
    val crypto: Crypto? = null,
    val firstName: String? = null,
    val macAddress: String? = null,
    val phone: String? = null,
    val age: Int? = null,
    val username: String? = null,
    val isFavorite: Boolean = false
) : Parcelable