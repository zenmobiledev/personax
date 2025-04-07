package com.mobbelldev.personax.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Company(
    val address: Address? = null,
    val name: String? = null,
    val department: String? = null,
    val title: String? = null,
) : Parcelable