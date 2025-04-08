package com.mobbelldev.personax.presentation.detail.constant

import com.mobbelldev.personax.R
import com.mobbelldev.personax.presentation.detail.constant.HairType.entries

enum class HairType(val type: String, val image: Int) {
    STRAIGHT(type = "Straight", image = R.drawable.straight_hair),
    WAVY(type = "Wavy", image = R.drawable.wavy_hair),
    CURLY(type = "Curly", image = R.drawable.curly_hair),
    KINKY(type = "Kinky", image = R.drawable.curly_hair);

    companion object {
        fun fromString(value: String?): HairType? {
            return entries.firstOrNull { it.type.equals(value, ignoreCase = true) }
        }
    }
}