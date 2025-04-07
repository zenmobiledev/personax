package com.mobbelldev.personax.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Coordinates(
    val lng: @RawValue Any? = null,
    val lat: @RawValue Any? = null,
) : Parcelable