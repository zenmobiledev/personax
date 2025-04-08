package com.mobbelldev.personax.presentation.detail.constant

import com.mobbelldev.personax.R
import com.mobbelldev.personax.presentation.detail.constant.EyeColor.entries

enum class EyeColor(val color: String, val image: Int) {
    BLACK(color = "Black", image = R.drawable.black_eye_color),
    GREEN(color = "Green", image = R.drawable.green_eye_color),
    RED(color = "red", image = R.drawable.red_eye_color),
    HAZEL(color = "Hazel", image = R.drawable.hazel_eye_color),
    AMBER(color = "Amber", image = R.drawable.amber_eye_color),
    BLUE(color = "Blue", image = R.drawable.blue_eye_color),
    BROWN(color = "Brown", image = R.drawable.brown_eye_color),
    VIOLET(color = "Violet", image = R.drawable.violet_eye_color),
    GRAY(color = "Gray", image = R.drawable.gray_eye_color);

    companion object {
        fun fromString(value: String): EyeColor? {
            return entries.firstOrNull { it.color.equals(value, ignoreCase = true) }
        }
    }
}