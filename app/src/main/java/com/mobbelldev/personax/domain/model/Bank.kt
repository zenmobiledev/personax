package com.mobbelldev.personax.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bank(
    val iban: String? = null,
    val cardExpire: String? = null,
    val cardType: String? = null,
    val currency: String? = null,
    val cardNumber: String? = null,
) : Parcelable