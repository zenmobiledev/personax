package com.mobbelldev.personax.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hair(
    val color: String? = null,
    val type: String? = null,
) : Parcelable