package com.mobbelldev.personax.presentation.main.constant

import androidx.annotation.ColorRes
import com.mobbelldev.personax.R

enum class HairColor(val color: String, @ColorRes val value: Int) {
    BLONDE("Blonde", R.color.blonde),
    BLACK("Black", R.color.black),
    BROWN("Brown", R.color.brown),
    WHITE("White", R.color.white),
    RED("Red", R.color.red),
    GRAY("Gray", R.color.gray),
    BLUE("Blue", R.color.blue),
    GREEN("Green", R.color.green),
    PURPLE("Purple", R.color.purple);

    companion object {
        fun fromString(value: String): HairColor? {
            return entries.firstOrNull { it.color.equals(value, ignoreCase = true) }
        }
    }
}