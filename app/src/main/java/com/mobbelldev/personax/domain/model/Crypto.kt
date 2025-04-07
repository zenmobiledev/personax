package com.mobbelldev.personax.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Crypto(
    val wallet: String? = null,
    val coin: String? = null,
    val network: String? = null,
) : Parcelable