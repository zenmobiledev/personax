package com.mobbelldev.personax.presentation.detail.constant

import com.mobbelldev.personax.R

enum class BloodType(val type: String, val image: Int) {
    ABPLUS(type = "AB+", image = R.drawable.ab_plus),
    ABMINUS(type = "AB-", image = R.drawable.ab_minus),
    APLUS(type = "A+", image = R.drawable.a_plus),
    AMINUS(type = "A-", image = R.drawable.a_minus),
    BPLUS(type = "B+", image = R.drawable.b_plus),
    BMINUS(type = "B-", image = R.drawable.b_minus),
    OPLUS(type = "O+", image = R.drawable.o_plus),
    OMINUS(type = "O-", image = R.drawable.o_minus);

    companion object {
        fun fromString(value: String): BloodType? {
            return entries.firstOrNull { it.type.equals(value, ignoreCase = true) }
        }
    }
}